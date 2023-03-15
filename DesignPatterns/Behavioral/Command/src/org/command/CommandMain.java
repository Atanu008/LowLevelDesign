package org.command;

//https://www.educative.io/courses/software-design-patterns-best-practices/NE06o49n7P2
public class CommandMain {

    public static void main(String[] args) {
        Light light = new Light();
        Command switchOnCommand = new SwitchOnCommand(light);
        Command switchOfCommand = new SwitchOffCommand(light);

        ControlPanel controlPannel = new ControlPanel();
        controlPannel.setCommand(0, switchOnCommand);
        controlPannel.setCommand(1, switchOfCommand);

        controlPannel.switchOn();
        System.out.println("Is List On : "+ light.isSwitchedOn());
        controlPannel.switchOff();
        System.out.println("Is List On : "+ light.isSwitchedOn());

    }
}
