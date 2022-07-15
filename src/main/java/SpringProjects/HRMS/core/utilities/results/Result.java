/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springprojects.HRMS.core.utilities.results;

/**
 *
 * @author yasir
 */
public class Result {
    private boolean success;
    private String message;
    
    public Result(boolean success) {
        this.success = success;
    }
    
    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
