// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */

public class IO {
    private final int XBOX_PORT = 0;
    private final double DEADZONE = 0.05;
    private XboxController xbox;
    private Button rightTriggerButton;
    private Button leftTriggerButton;
    private Button radialUp;
    private Button radialRight;
    private Button radialDown;
    private Button radialLeft;

    public void init(){
        xbox = new XboxController(XBOX_PORT);
        initializeCustomButtons();
    }

    public double filter(double input){
        //filter
        double x = Math.copySign(Math.pow(input, 2), input);
        return MathUtil.applyDeadband(x, DEADZONE);
    }
    
    public enum ButtonActionType {
        WHEN_HELD,
        WHEN_PRESSED,
        WHEN_RELEASED,
        WHILE_HELD,
        CANCEL_WHEN_PRESSED,
        TOGGLE_WHEN_PRESSED;
    }

    public enum ControllerButton {
        kLeftBumper(5),
        kRightBumper(6),
        kLeftStick(9),
        kRightStick(10),
        kA(1),
        kB(2),
        kX(3),
        kY(4),
        kBack(7),
        kStart(8);

        public final int VALUE;
        
        ControllerButton(int VALUE) {
            this.VALUE = VALUE;
         }
    }    

    public void bind(ButtonActionType type, ControllerButton xboxButton, CommandBase command) {
        JoystickButton joystickButton = new JoystickButton(xbox, xboxButton.VALUE);
        
        switch(type)
        {
            case CANCEL_WHEN_PRESSED:
                joystickButton.cancelWhenPressed(command);
                break;
            case TOGGLE_WHEN_PRESSED:
                joystickButton.toggleWhenPressed(command);
                break;
            case WHEN_HELD:
                joystickButton.whenHeld(command);
                break;
            case WHEN_PRESSED:
                joystickButton.whenPressed(command);
                break;
            case WHEN_RELEASED:
                joystickButton.whenReleased(command);
                break;
            case WHILE_HELD:
                joystickButton.whileHeld(command);
                break;
        }

    }

    public void initializeCustomButtons(){
        rightTriggerButton = new Button( () -> {
            return xbox.getRightTriggerAxis()>0.5; 
        } );
        leftTriggerButton = new Button( () -> {
            return xbox.getLeftTriggerAxis()>0.5;
        } );
        radialUp = new Button( () -> {
            return xbox.getPOV()==0;
        } );
        radialRight = new Button( () -> {
            return xbox.getPOV()==90;
        } );
        radialDown = new Button( () -> {
            return xbox.getPOV()==180;
        } );
        radialLeft = new Button( () -> {
            return xbox.getPOV()==270;
        } );
    }
    
    public double getLeftX(){
        return filter(xbox.getLeftX());
    }

    public double getRightX(){
        return filter(xbox.getRightX());
    }
    
    public double getLeftY(){
        return filter(xbox.getLeftY());
    }

    public double getRightY(){
        return filter(xbox.getRightY());
    }
}


