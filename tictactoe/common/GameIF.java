
package common;

/**
 * This interface implements the abstract method used to receive
 * commands and display message by the client or server UI
 *
 */
public interface GameIF 
{
  //display message  
  public abstract void display(String message);
  //receive command
  public abstract void receiveCommand(String command);
}
