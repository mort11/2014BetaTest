/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    RobotDrive dt = new RobotDrive(new Talon(1), new Talon(3), new Talon(2), new Talon(4));
    Joystick dtLeftJoy = new Joystick(1);
    Joystick dtRightJoy = new Joystick(2);
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        dt.setSafetyEnabled(false);
        dt.drive(-0.5, 0);
        Timer.delay(2);
        dt.drive(0, 0);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        dt.setSafetyEnabled(true);
        while(isOperatorControl() && isEnabled()){
            dt.tankDrive(-dtLeftJoy.getY(), -dtRightJoy.getY());
        }

    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
