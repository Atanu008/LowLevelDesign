package org.command;

//we dont have to conditionally check for condition and do stuffs in component(Control Panel)
// we will attach behavior and the behaviour will be executed
public class ControlPanel {

    // Only two commands for now
    Command[] commands = new Command[2];

    public void setCommand(int i, Command command) {
        commands[i] = command;
    }

    public void switchOn(){
        // Assuming that the client correctly sets the first
        // index to be switch ON command
        commands[0].execute();
    }

    public void switchOff(){
        // Assuming that the client correctly sets the second
        // index to be switch OFF command
        commands[1].execute();
    }

}
