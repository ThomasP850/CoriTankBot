// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

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
        double x = Math.copySign(Math.pow(input, 2), input);
        return MathUtil.applyDeadband(x, DEADZONE);
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
}

