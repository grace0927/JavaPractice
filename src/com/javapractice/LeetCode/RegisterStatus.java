/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.LeetCode;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jianyu
 */
public class RegisterStatus {
    public static final String USERNAME = "userName";
    public static final String STATUS = "status";
    
    private List<User> users = new ArrayList<User>();
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();
    
    public class User {
        private String userName;
        private String status;
        
        public User(String userName, String status) {
            this.userName = userName;
            this.status = status;
        }
        
        public String getUserName() {
            return userName;
        }
        
        public void setUserName(String userName) {
            notifyListeners(this,
                    USERNAME,
                    this.userName,
                    this.userName = userName);
        }
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            notifyListeners(this,
                    this.userName,
                    this.status,
                    this.status = status);
        }
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public void addUsers(String userName, String status) {
        users.add(new User(userName, status));
    }
    
    public RegisterStatus() {
    // Just for testing we hard-code the persons here:
        //users.add(new User("SWTI248", "offline"));
        //users.add(new User("SWTI243", "offline"));
    }
    
    private void notifyListeners(Object object, String userName, String oldValue, String newValue) {
        for(PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, userName, oldValue, newValue));
        }
    }
    
    public void addChangeListener(PropertyChangeListener newListener) {
        listener.add(newListener);
    }
}
