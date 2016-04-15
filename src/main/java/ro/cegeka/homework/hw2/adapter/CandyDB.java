package ro.cegeka.homework.hw2.adapter;

import java.sql.*;

/**
 * Created by John Smith on 15.04.2016.
 */
public class CandyDB extends Candy {

    private static String dbURL = "jdbc:derby:C:\\Users\\Alexandru\\MyDB;create=true";
    private static Connection connection = null;
    private static Statement statement = null;


    protected Long id;
    protected int updatedAt;
    protected int createdAt;

    public Long getId() {
        return id;
    }

    public CandyDB setId(Long id) {
        this.id = id;
        return this;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public CandyDB setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public CandyDB setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public static void createConnection() {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connection = DriverManager.getConnection(dbURL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){

        try{
            if(statement != null)
                statement.close();

            if(connection != null)
                // 		Doar o alta metoda de a inchide conexiunea
                //		connection = DriverManager.getConnection(dbURL + "; shutdown=true");
                connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertCandy(){

        try {
            statement = connection.createStatement();

            statement.execute("insert into ASE.TEST values("
                    + this.getId() + ",'"
                    + this.getName() + "','"
                    + this.getForm() + "',"
                    + this.getPrice() + ","
                    + this.getWeight() + ",'"
                    + this.getExpireDate() + "')");

            statement.close();
            this.setCreatedAt(1);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void updateCandy(int id, String candy){

        try{
            if(this.getCreatedAt() == 1) {
                statement = connection.createStatement();

                statement.execute("update ase.test set name = '" + candy + "' where id =" + id);

                statement.close();

                this.setUpdatedAt(1);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void deleteCandy(int id){

        try{

            if(this.getCreatedAt() == 1) {
                statement = connection.createStatement();

                statement.execute("delete from ase.test where id =" + id);

                statement.close();
                this.setCreatedAt(0);
                this.setUpdatedAt(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
