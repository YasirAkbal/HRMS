/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springprojects.HRMS.core.utilities.results;

/**
 *
 * @author yasir
 */
public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }
    
    public SuccessResult(String message) {
        super(true, message);
    }
}
