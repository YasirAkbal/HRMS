/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springprojects.HRMS.core.utilities.results;

/**
 *
 * @author yasir
 */
public class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }
    
    public ErrorResult(String message) {
        super(false, message);
    }
}
