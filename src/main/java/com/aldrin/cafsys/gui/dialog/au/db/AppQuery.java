/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.cafsys.gui.dialog.au.db;

import com.aldrin.cafsys.api.ComboBoxList;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class AppQuery {

    DBConnection c = new DBConnection();
    private ArrayList<ComboBoxList> list;
    private static String al = "";
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    /**
     * @return the list
     */
    public ArrayList<ComboBoxList> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<ComboBoxList> list) {
        this.list = list;
    }

    public ArrayList<com.aldrin.cafsys.model.User> selectUser() {
        ArrayList<com.aldrin.cafsys.model.User> list = new ArrayList<>();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT\n"
                    + " user.id,   CONCAT( `user`.`lastname`,', ', `user`.`firstname`, ' ',SUBSTRING(UPPER(`user`.`middlename`),1,1),'.')AS Uname \n"
                    + "    ,`user`.`firstname`\n"
                    + "    , `user`.`middlename`\n"
                    + "    , `user`.`lastname`\n"
                    + "    , `user`.`email`\n"
                    + "    , `user`.`mobile_no`\n"
                    + "    , `user`.`username`\n"
                    + "    , `user`.`password`\n"
                    + "    , `user`.`photo`\n"
                    + "FROM\n"
                    + "   `user` WHERE user.`deleted` =0 ORDER BY user.`lastname` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                com.aldrin.cafsys.model.User c = new com.aldrin.cafsys.model.User();
                c.setId(rs.getInt("id"));
                c.setFirstname(rs.getString("firstname"));
                c.setMiddlename(rs.getString("middlename"));
                c.setLastname(rs.getString("lastname"));
                c.setEmail(rs.getString("email"));
                c.setMobileNo(rs.getString("mobile_no"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("password"));
                list.add(c);
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addUser(com.aldrin.cafsys.model.User user, File photo) {
        try {
            FileInputStream fis = null;
            c.getDBConn();
            fis = new FileInputStream(photo);
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `user` (\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `email`,\n"
                    + "  `mobile_no`,\n"
                    + "  `username`,\n"
                    + "  `password`,\n"
                    + "  `photo`) \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?,?,?,?) ;");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getMiddlename());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getMobileNo());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setBlob(8, fis, (int) photo.length());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(com.aldrin.cafsys.model.User user, File photo, int userId, boolean image) {
        try {
            FileInputStream fis = null;
            c.getDBConn();
            fis = new FileInputStream(photo);
            if (image == false) {
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `user` \n"
                        + "SET  \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `username` = ?,\n"
                        + "  `password` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getMiddlename());
                ps.setString(3, user.getLastname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getMobileNo());
                ps.setString(6, user.getUsername());
                ps.setString(7, user.getPassword());
                ps.setInt(8, userId);
                ps.execute();
                ps.close();
                c.closeConnection();
            } else {
                java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `user` \n"
                        + "SET  \n"
                        + "  `firstname` = ?,\n"
                        + "  `middlename` = ?,\n"
                        + "  `lastname` = ?,\n"
                        + "  `email` = ?,\n"
                        + "  `mobile_no` = ?,\n"
                        + "  `username` = ?,\n"
                        + "  `password` = ?,\n"
                        + "  `photo` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getMiddlename());
                ps.setString(3, user.getLastname());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getMobileNo());
                ps.setString(6, user.getUsername());
                ps.setString(7, user.getPassword());
                ps.setBlob(8, fis, (int) photo.length());
                ps.setInt(9, userId);
                ps.execute();
                ps.close();
                c.closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int idl) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("update user  set  deleted = 1  where  id = ? ;");
            ps.setInt(1, idl);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Blob selectUserPicture(int id) {
        Blob photo = null;
        try {

            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM user  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("photo");
                photo = picturel;
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return photo;
    }

    public void updatePassword(String password) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `user`  SET  `password` = ?    WHERE `id` = ? ;");
            ps.setString(1, password);
//            ps.setInt(2, new com.aldrin.cafsys.gui.dialog.au.db.LoginUser().getUser().getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean selectPasswordSHA256(int id) {
        boolean passwordMatch = false;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  password FROM user  where id  =" + id + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String pass = rs.getString("password");
                passwordMatch =true;
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordMatch;

    }

    public void addCategory(com.aldrin.cafsys.model.Category category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `category` (`category`, `description`) \n"
                    + "VALUES\n"
                    + "  (?,?) ;");
            ps.setString(1, category.getCategory());
            ps.setString(2, category.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(com.aldrin.cafsys.model.Category category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `category` \n"
                    + "SET \n"
                    + "  `category` = ?,\n"
                    + "  `description` = ? \n"
                    + "WHERE `id` = ? ");
            ps.setString(1, category.getCategory());
            ps.setString(2, category.getDescription());
            ps.setInt(3, category.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(com.aldrin.cafsys.model.Category category) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `category` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, category.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void categoryComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `category`\n"
                    + "FROM\n"
                    + "  `category` WHERE deleted =0 ORDER BY `category` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("category");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<com.aldrin.cafsys.model.Category> getCategory() {
        ArrayList<com.aldrin.cafsys.model.Category> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `category`,\n"
                    + "  `description`\n"
                    + "FROM\n"
                    + "  `cafsys`.`category` WHERE `deleted` =0 ORDER BY `category` ASC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Category c = new com.aldrin.cafsys.model.Category();
                c.setId(rs.getInt("id"));
                c.setCategory(rs.getString("category"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public ArrayList<com.aldrin.cafsys.model.Category> getCategoryOfTheDay() {
        ArrayList<com.aldrin.cafsys.model.Category> list = new ArrayList<>();
        try {
            String query = "SELECT    `category`.`id` , `category`.`category`, `category`.`description` \n"
                    + "  FROM \n"
                    + " `menu`  \n"
                    + "INNER JOIN `category`   \n"
                    + "ON (`menu`.`category_id` = `category`.`id`)  \n"
                    + " WHERE `category`.`deleted` =0  GROUP BY `category`.`id` ORDER BY `category` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Category c = new com.aldrin.cafsys.model.Category();
                c.setId(rs.getInt("id"));
                c.setCategory(rs.getString("category"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public LinkedList<com.aldrin.cafsys.model.Menu> getMenuByCategory(Integer categoryId) {
        LinkedList<com.aldrin.cafsys.model.Menu> list = new LinkedList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `menu`,\n"
                    + "  `price` \n"
                    + "FROM\n"
                    + "  `menu` WHERE `category_id` =" + categoryId;
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Menu c = new com.aldrin.cafsys.model.Menu();
                c.setId(rs.getInt("id"));
                c.setMenu(rs.getString("menu"));
                c.setPrice(rs.getDouble("price"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public LinkedList<com.aldrin.cafsys.model.MOTD> getMenuByCategoryIdMenuId(Integer categoryId) {
        LinkedList<com.aldrin.cafsys.model.MOTD> list = new LinkedList<>();
        try {
            String query = "SELECT  \n"
                    + "    `motd`.`id`,`motd`.`menu_id` \n"
                    + "    , `menu`.`menu`\n"
                    + "    , `menu`.`price`\n"
                    + " \n"
                    + " FROM \n"
                    + "    `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`)WHERE  `motd`.`deleted` =0 and `menu`.`category_id` =" + categoryId + "  AND `motd`.`date` =CURDATE()";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.MOTD c = new com.aldrin.cafsys.model.MOTD();
                c.setId(rs.getInt("id"));
                c.setMenuId(rs.getInt("menu_id"));
                c.setMenu(rs.getString("menu"));
                c.setPrice(rs.getDouble("price"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void addMenu(com.aldrin.cafsys.model.Menu menu) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(menu.getPhoto());
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `menu` (`category_id`,\n"
                    + "  `menu`,\n"
                    + "  `price`,\n"
                    + "  `ingredient`,photo\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?,?) ;");
            ps.setInt(1, menu.getCategory().getId());
            ps.setString(2, menu.getMenu());
            ps.setDouble(3, menu.getPrice());
            ps.setString(4, menu.getIngredient());
            ps.setBlob(5, fis, (int) menu.getPhoto().length());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMenu(com.aldrin.cafsys.model.Menu menu, boolean image) {
        FileInputStream fis = null;
        try {
            c.getDBConn();
            fis = new FileInputStream(menu.getPhoto());
            java.sql.PreparedStatement ps;
            if (image == false) {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `menu` \n"
                        + "SET  \n"
                        + "  `category_id` = ?,\n"
                        + "  `menu` = ?,\n"
                        + "  `price` = ?,\n"
                        + "  `ingredient` = ? \n"
                        + " WHERE `id` = ? ;");
                ps.setInt(1, menu.getCategory().getId());
                ps.setString(2, menu.getMenu());
                ps.setDouble(3, menu.getPrice());
                ps.setString(4, menu.getIngredient());
                ps.setInt(5, menu.getId());
            } else {
                ps = c.getCon().prepareStatement("UPDATE \n"
                        + "  `menu` \n"
                        + "SET  \n"
                        + "  `category_id` = ?,\n"
                        + "  `menu` = ?,\n"
                        + "  `price` = ?,\n"
                        + "  `ingredient` = ?,\n"
                        + "  `photo` = ?\n"
                        + "WHERE `id` = ? ;");
                ps.setInt(1, menu.getCategory().getId());
                ps.setString(2, menu.getMenu());
                ps.setDouble(3, menu.getPrice());
                ps.setString(4, menu.getIngredient());
                ps.setBlob(5, fis, (int) menu.getPhoto().length());
                ps.setInt(6, menu.getId());
            }
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMenu(com.aldrin.cafsys.model.Menu menu) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE `menu` \n"
                    + "SET\n"
                    + "  `deleted` = 1  WHERE `id` = ? ;");
            ps.setInt(1, menu.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<com.aldrin.cafsys.model.Menu> getMenuList() {
        ArrayList<com.aldrin.cafsys.model.Menu> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `menu`.`id`\n"
                    + "    , `menu`.`category_id`\n"
                    + "    , `category`.`category`\n"
                    + "    , `menu`.`menu`\n"
                    + "    , `menu`.`price`\n"
                    + "    , `menu`.`ingredient` \n"
                    + " FROM  \n"
                    + "    `menu`\n"
                    + "    INNER JOIN `category` \n"
                    + "        ON (`menu`.`category_id` = `category`.`id`) where menu.deleted =0   order by `category`.`category` asc";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Category c = new com.aldrin.cafsys.model.Category();
                com.aldrin.cafsys.model.Menu m = new com.aldrin.cafsys.model.Menu();
                m.setId(rs.getInt("id"));
                c.setId(rs.getInt("category_id"));
                c.setCategory(rs.getString("category"));
                m.setMenu(rs.getString("menu"));
                m.setCategory(c);
                m.setPrice(rs.getDouble("price"));
                m.setIngredient(rs.getString("ingredient"));
                list.add(m);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Blob selectedMenuPicture(com.aldrin.cafsys.model.Menu menu) {
        Blob pic = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  photo FROM menu  where id  =" + menu.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Blob picturel = rs.getBlob("photo");
                pic = picturel;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return pic;
    }

    public void menuComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `category`\n"
                    + "FROM\n"
                    + "  `category` WHERE deleted =0 ORDER BY `category` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String coursel = rs.getString("category");

                // Process data here
                this.getList().add(new ComboBoxList(idl, coursel));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateMenuPrice(Double price, Integer id) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `menu` \n"
                    + "SET  \n"
                    + "  `price` = ? \n"
                    + "WHERE `id` = ? ");
            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMenuOfTheDay(com.aldrin.cafsys.model.Menu menu) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `motd` (\n"
                    + "  `menu_id`,\n"
                    + "  `price`,\n"
                    + "  `date`,\n"
                    + "  `user_id`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,CURDATE(),?) ;");
            ps.setInt(1, menu.getId());
            ps.setDouble(2, menu.getPrice());
            ps.setInt(3, 1);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean selectMenuOfTheDay(int id) {
        Boolean motd = false;
        try {

            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `menu_id`,\n"
                    + "  `price`,\n"
                    + "  `date`,\n"
                    + "  `user_id`,\n"
                    + "  `deleted` \n"
                    + "FROM\n"
                    + "  `motd` WHERE `date` =CURDATE() AND `menu_id` =?  and deleted =0 ; ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                motd = true;
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return motd;
    }

    public void updateMotD(Integer id) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `motd` \n"
                    + "SET\n"
                    + "  `deleted` = 1 \n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public com.aldrin.cafsys.model.Menu getMenuAddToTable(Integer categoryId) {
        com.aldrin.cafsys.model.Menu menu = null;
        try {
            String query = "SELECT  \n"
                    + "    `motd`.`menu_id`\n"
                    + "    , `menu`.`menu`\n"
                    + "    , `menu`.`price`\n"
                    + " \n"
                    + " FROM \n"
                    + "    `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`)WHERE  `motd`.`deleted` =0 and `menu`.`category_id` =" + categoryId + "  AND `motd`.`date` =CURDATE()";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Menu c = new com.aldrin.cafsys.model.Menu();
                c.setId(rs.getInt("menu_id"));
                c.setMenu(rs.getString("menu"));
                c.setPrice(rs.getDouble("price"));

            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return menu;
    }

    public com.aldrin.cafsys.model.MOTD addOrderToTable(com.aldrin.cafsys.model.MOTD m) {
        com.aldrin.cafsys.model.MOTD motd = new com.aldrin.cafsys.model.MOTD();
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT  \n"
                    + "    `motd`.`id`\n"
                    + "    ,`motd`.`menu_id`\n"
                    + "    , `menu`.`menu`\n"
                    + "    , `menu`.`price`\n"
                    + "\n"
                    + "FROM\n"
                    + "    `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`)WHERE `motd`.`id` =?  AND `motd`.`date` =CURDATE()");
            statement.setInt(1, m.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                motd.setId(rs.getInt("id"));
                motd.setMenuId(rs.getInt("menu_id"));
                motd.setMenu(rs.getString("menu"));
                motd.setPrice(rs.getDouble("price"));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return motd;
    }

    public boolean loginUser(String username, String password) {
        boolean login = false;
        try {
            c.getDBConn();
            String pw = new PasswordChecker(password).toString();
            PreparedStatement psmt = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `middlename`,\n"
                    + "  `lastname`,\n"
                    + "  `username`,\n"
                    + "  `password`\n"
                    + "FROM \n"
                    + "  `user` WHERE `username` =? AND `password` =?; ");
            psmt.setString(1, username);
            psmt.setString(2, pw);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String middlenamel = rs.getString("middlename");
                String lastname = rs.getString("lastname");
                String usernamel = rs.getString("username");
                String passwordl = rs.getString("password");
                login = true;
                com.aldrin.cafsys.model.User user = new com.aldrin.cafsys.model.User(id, firstname, middlenamel, lastname, usernamel, password);
//                new com.aldrin.cafsys.gui.dialog.au.db.LoginUser().setUser(user);
            }
            c.closeConnection();
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println(e2);
        }
        return login;

    }

    public void addInvoice(com.aldrin.cafsys.model.Invoice invoice) {
        try {
            c.getDBConn();
            //user login
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `invoice` (\n"
                    + "  `user_id`,\n"
                    + "  customer_cash,table_no, taking_meals_id \n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?,?) ;");
//            ps.setInt(1, new com.aldrin.cafsys.gui.dialog.au.db.LoginUser().getUser().getId());
            ps.setDouble(2, invoice.getCustomerCash());
            ps.setInt(3, invoice.getTableNo());
            ps.setInt(4, invoice.getTakingMealsId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long selectMaxInvoiceId() {
        Long maxId = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  MAX(`id`) AS id \n"
                    + " \n"
                    + "FROM\n"
                    + "  `invoice` ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("id");
                maxId = idl;
            }
            rs.close();
//            statement.close();
//            u.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

    public void addOrder(com.aldrin.cafsys.model.Order order) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `order` (\n"
                    + "  `invoice_id`,\n"
                    + "  `motd_id`,\n"
                    + "  `qty`\n"
                    + ") \n"
                    + "VALUES\n"
                    + "  (?,?,?) ;");
            ps.setLong(1, Long.parseLong(selectMaxInvoiceId().toString()));
            ps.setInt(2, order.getMotd().getId());
            ps.setInt(3, order.getQty());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<com.aldrin.cafsys.model.Invoice> getInvoiceList() {
        ArrayList<com.aldrin.cafsys.model.Invoice> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "     `invoice`.`id` \n"
                    + "    , CONCAT(`user`.`lastname`  ,', '  ,`user`.`firstname` ,' ', SUBSTRING(`user`.`middlename`,1,1) ,'.') AS userName \n"
                    + "    ,DATE_FORMAT(`invoice`.`date_time`,'%b. %d, %Y %r') as date_time\n"
                    + "    ,  COUNT(*) AS noOfOrders\n"
                    + "    , SUM(`order`.`qty`*`motd`.`price`) AS lineTotal \n"
                    + "\n"
                    + "           FROM \n"
                    + "            `invoice`\n"
                    + "              INNER JOIN `user` \n"
                    + "                 ON (`invoice`.`user_id` = `user`.`id`)\n"
                    + "               INNER JOIN `order` \n"
                    + "                  ON (`order`.`invoice_id` = `invoice`.`id`)\n"
                    + "                     INNER JOIN `motd` \n"
                    + "                     ON (`order`.`motd_id` = `motd`.`id`)\n"
                    + "                INNER JOIN `menu` \n"
                    + "                      ON (`motd`.`menu_id` = `menu`.`id`)\n"
                    + "                  INNER JOIN `category` \n"
                    + "                  ON (`menu`.`category_id` = `category`.`id`) GROUP BY `invoice`.`id`  ORDER BY `order`.`id` DESC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.User u = new com.aldrin.cafsys.model.User();
                u.setFirstname(rs.getString("userName"));
                com.aldrin.cafsys.model.Invoice i = new com.aldrin.cafsys.model.Invoice();
                i.setId(rs.getLong("id"));
                i.setUser(u);//username
                i.setDateTime(rs.getString("date_time"));
                i.setNoOfOrders(rs.getInt("noOfOrders"));
                i.setCustomerCash(rs.getDouble("lineTotal"));
                list.add(i);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public ArrayList<com.aldrin.cafsys.model.Order> getInvoiceDetails(com.aldrin.cafsys.model.Invoice invoice) {
        ArrayList<com.aldrin.cafsys.model.Order> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `order`.`qty`\n"
                    + "    , `motd`.`price`\n"
                    + "    , (`order`.`qty`*`motd`.`price`) AS total\n"
                    + "    , `menu`.`menu`\n"
                    + "    , `category`.`category`\n"
                    + "FROM\n"
                    + "    `invoice`\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`invoice`.`user_id` = `user`.`id`)\n"
                    + "    INNER JOIN `order` \n"
                    + "        ON (`order`.`invoice_id` = `invoice`.`id`)\n"
                    + "    INNER JOIN `motd` \n"
                    + "        ON (`order`.`motd_id` = `motd`.`id`)\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`)\n"
                    + "    INNER JOIN `category` \n"
                    + "        ON (`menu`.`category_id` = `category`.`id`)WHERE `invoice`.`id` =" + invoice.getId() + " ORDER BY `order`.`id` ASC ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Order o = new com.aldrin.cafsys.model.Order();
                com.aldrin.cafsys.model.MOTD motd = new com.aldrin.cafsys.model.MOTD();
                com.aldrin.cafsys.model.Category c = new com.aldrin.cafsys.model.Category();
                motd.setMenu(rs.getString("menu"));
                c.setCategory(rs.getString("category"));
                o.setQty(rs.getInt("qty"));
                o.setPrice(rs.getFloat("price"));
                o.setTotal(rs.getFloat("total"));
                o.setMotd(motd);
                o.setCategory(c);
                list.add(o);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public ArrayList<com.aldrin.cafsys.model.Invoice> getSalesUser(Integer userId, int startId, int endId) {
        ArrayList<com.aldrin.cafsys.model.Invoice> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "    `invoice`.`id`\n"
                    + "    , SUM(`order`.`qty`*`motd`.`price`) AS total\n"
                    + "    , DATE_FORMAT(`invoice`.`date_time`,'%b. %d, %Y %r') AS dt \n"
                    + " FROM \n"
                    + "    `invoice`\n"
                    + "    INNER JOIN `user` \n"
                    + "        ON (`invoice`.`user_id` = `user`.`id`)\n"
                    + "    INNER JOIN `order` \n"
                    + "        ON (`order`.`invoice_id` = `invoice`.`id`)\n"
                    + "    INNER JOIN `motd` \n"
                    + "        ON (`order`.`motd_id` = `motd`.`id`)\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`)\n"
                    + "    INNER JOIN `category` \n"
                    + "        ON (`menu`.`category_id` = `category`.`id`)WHERE `invoice`.`user_id` =" + userId + "  AND  ((`invoice`.`id` >=" + startId + ") AND ( `invoice`.`id`<=" + endId + "))     GROUP BY `invoice`.`id`  ORDER BY `order`.`id` desc ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Invoice i = new com.aldrin.cafsys.model.Invoice();
                i.setId(rs.getLong("id"));
                i.setTotal(rs.getDouble("total"));
                i.setDateTime(rs.getString("dt"));
                list.add(i);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
        }
        return list;
    }

    public void userComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  CONCAT(`lastname`,', ',`firstname`,' ',SUBSTRING(`middlename`,1,1),'.') AS userN\n"
                    + "FROM `user` order by lastname asc");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String userN = rs.getString("userN");

                // Process data here
                this.getList().add(new ComboBoxList(idl, userN));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void invoiceDateTimeComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  DATE_FORMAT(`date_time`,'%b. %d, %Y %r') AS dt \n"
                    + "FROM\n"
                    + "  `invoice` ORDER BY `invoice`.`id` DESC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String dt = rs.getString("dt");

                // Process data here
                this.getList().add(new ComboBoxList(idl, dt));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addDiscount(com.aldrin.cafsys.model.Discount discount) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `discount` ( `discount`,`percentage`, `description`) \n"
                    + "VALUES(?,?,?) ;");
            ps.setString(1, discount.getDiscount());
            ps.setFloat(2, discount.getPercentage());
            ps.setString(3, discount.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDiscount(com.aldrin.cafsys.model.Discount discount) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `discount` \n"
                    + "SET \n"
                    + "  `discount` =?,`percentage` = ?,\n"
                    + "  `description` = ?\n"
                    + "WHERE `id` = ?;");
            ps.setString(1, discount.getDiscount());
            ps.setFloat(2, discount.getPercentage());
            ps.setString(3, discount.getDescription());
            ps.setInt(4, discount.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDiscount(com.aldrin.cafsys.model.Discount discount) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `discount` \n"
                    + "SET\n"
                    + "  `deleted` = 1\n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, discount.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<com.aldrin.cafsys.model.Discount> getDiscount() {
        ArrayList<com.aldrin.cafsys.model.Discount> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `percentage`,\n"
                    + "  `discount`,description\n"
                    + "FROM\n"
                    + " `discount` ORDER BY  `percentage` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Discount c = new com.aldrin.cafsys.model.Discount();
                c.setId(rs.getInt("id"));
                c.setDiscount(rs.getString("discount"));
                c.setPercentage(rs.getFloat("percentage"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void takingMealsComboBox() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `taking_meals`,\n"
                    + "  `description`\n"
                    + "FROM\n"
                    + " `taking_meals` ORDER BY  `taking_meals` ASC;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String idl = rs.getString("id");
                String takingMeals = rs.getString("taking_meals");
//                String descriptionl = rs.getString("description");

                // Process data here
                this.getList().add(new ComboBoxList(idl, takingMeals));
            }
            rs.close();
            statement.close();
            c.closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addTax(com.aldrin.cafsys.model.Tax tax) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("INSERT INTO `tax` ( `tax`,`percentage`, `description`) \n"
                    + "VALUES(?,?,?) ;");
            ps.setString(1, tax.getTax());
            ps.setFloat(2, tax.getPercentage());
            ps.setString(3, tax.getDescription());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTax(com.aldrin.cafsys.model.Tax discount) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `tax` \n"
                    + "SET \n"
                    + "  `tax` =?,`percentage` = ?,\n"
                    + "  `description` = ?\n"
                    + "WHERE `id` = ?;");
            ps.setString(1, discount.getTax());
            ps.setFloat(2, discount.getPercentage());
            ps.setString(3, discount.getDescription());
            ps.setInt(4, discount.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTax(com.aldrin.cafsys.model.Tax tax) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE \n"
                    + "  `tax` \n"
                    + "SET\n"
                    + "  `deleted` = 1\n"
                    + "WHERE `id` = ? ;");
            ps.setInt(1, tax.getId());
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<com.aldrin.cafsys.model.Tax> getTax() {
        ArrayList<com.aldrin.cafsys.model.Tax> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `id`,\n"
                    + "  `percentage`,\n"
                    + "  `tax`,description\n"
                    + "FROM\n"
                    + " `tax` ORDER BY  `percentage` ASC;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                com.aldrin.cafsys.model.Tax c = new com.aldrin.cafsys.model.Tax();
                c.setId(rs.getInt("id"));
                c.setTax(rs.getString("tax"));
                c.setPercentage(rs.getFloat("percentage"));
                c.setDescription(rs.getString("description"));
                list.add(c);
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Integer selectTakingMeals(int id) {
        Integer maxId = null;
        try {
            c.getDBConn();
            PreparedStatement statement = c.getCon().prepareStatement("SELECT \n"
                    + "  `id`\n"
                    + "FROM\n"
                    + "  `taking_meals` WHERE id =?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt("id");
            }
            rs.close();
            statement.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return maxId;
    }

    public Boolean getMotDUpdated(Integer menuId) {
        Boolean updated = false;
        try {
            String query = "SELECT\n"
                    + "    `motd`.`id`\n"
                    + "    , `menu`.`id`\n"
                    + "    , `motd`.`date`\n"
                    + "FROM\n"
                    + "   `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`) WHERE `motd`.`menu_id` =" + menuId + " AND `motd`.`date` =CURRENT_DATE();";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer n = rs.getInt("id");
                if (n != null) {
                    updated = true;
                } else {
                    updated = false;
                }
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return updated;
    }

    public void updateMotD2(Integer id) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `motd` \n"
                    + "                    SET\n"
                    + "                     `deleted` = 1 \n"
                    + "                    WHERE `menu_id` = ?  AND `date` =CURRENT_DATE()");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean getMotDRemove(Integer menuId) {
        Boolean updated = false;
        try {
            String query = "SELECT\n"
                    + "    `motd`.`id`\n"
                    + "    , `menu`.`id`\n"
                    + "    , `motd`.`date`\n"
                    + "FROM\n"
                    + "   `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`) WHERE `motd`.`menu_id` =" + menuId + " AND `motd`.`date` =CURRENT_DATE()   and   `motd`.deleted =1  ; ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer n = rs.getInt("id");
                if (n != null) {
                    updated = true;
                } else {
                    updated = false;
                }
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return updated;
    }

    public Boolean getMotDDeletedRecover(Integer menuId) {
        Boolean updated = false;
        try {
            String query = "SELECT\n"
                    + "    `motd`.`id`\n"
                    + "    , `menu`.`id`\n"
                    + "    , `motd`.`date`\n"
                    + "FROM\n"
                    + "   `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`) WHERE `motd`.`menu_id` =" + menuId + " AND `motd`.`date` =CURRENT_DATE()  AND   `motd`.deleted =1   ;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer n = rs.getInt("id");
                updateMotDUpdateDeleted(n);

                if (n != null) {
                    updated = true;
                } else {
                    updated = false;
                }
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return updated;
    }

    public Boolean getMotDUpdateDeleted(Integer id) {
        Boolean updated = false;
        try {
            String query = "SELECT\n"
                    + "    `motd`.`id`\n"
                    + "    , `menu`.`id`\n"
                    + "    , `motd`.`date`\n"
                    + "FROM\n"
                    + "   `motd`\n"
                    + "    INNER JOIN `menu` \n"
                    + "        ON (`motd`.`menu_id` = `menu`.`id`) WHERE `motd`.`id` =" + id + " AND `motd`.`date` =CURRENT_DATE()   ; ";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer n = rs.getInt("id");
                if (n != null) {
                    updated = true;
                } else {
                    updated = false;
                }
            }
            rs.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return updated;
    }

    public void updateMotDUpdateDeleted(Integer id) {
        try {
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("UPDATE  `motd` \n"
                    + "                    SET\n"
                    + "                     `deleted` = 0 \n"
                    + "                    WHERE `id` = ?  AND `date` =CURRENT_DATE()");
            ps.setInt(1, id);
            ps.execute();
//            ps.close();
//            c.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
