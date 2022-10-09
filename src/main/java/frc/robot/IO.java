// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;

/** Add your docs here. */

public class IO {
    private final int XBOX_PORT = 0;
    private final double DEADZONE = 0.05;
    private XboxController xbox;

    public void init(){
        xbox = new XboxController(XBOX_PORT);
    }

    public double filter(double input){
        //filter
        double x = Math.copySign(Math.pow(input, 2), input);
        return MathUtil.applyDeadband(x, DEADZONE);
    }

}

