/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springprojects.HRMS.core.utilities.results;

/**
 *
 * @author yasir
 */
public class ErrorDataResult<T> extends DataResult<T> {
    
    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }
    
    public ErrorDataResult(T data) {
        super(data, false);
    }
    
    public ErrorDataResult(String message) {
        super(null, false, message);
    }
    
    public ErrorDataResult() {
        super(null, false);
    }
    
}