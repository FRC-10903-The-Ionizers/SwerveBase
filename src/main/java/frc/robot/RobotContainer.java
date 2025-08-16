// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import choreo.auto.AutoChooser;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;
import frc.robot.util.Auto;
import frc.robot.subsystems.Controller;;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	PowerDistribution powerDistribution = new PowerDistribution(16, ModuleType.kCTRE);

	Swerve swerve = new Swerve();

	Controller controller = new Controller(swerve);

	final AutoChooser autoChooser;
    Auto auto = new Auto(swerve);

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		
		autoChooser = new AutoChooser();

        autoChooser.addRoutine("FromLeft", auto::fromLeft);
        autoChooser.addRoutine("FromMid", auto::fromMid);
        autoChooser.addRoutine("FromRight", auto::fromRight);

        SmartDashboard.putData("Autos", autoChooser);

        autoChooser.select("FromMid");

        SmartDashboard.putData("Swerve", swerve);
        SmartDashboard.putData("Field", swerve.field);
        SmartDashboard.putData("Gyro", swerve.gyroAhrs);

        // SmartDashboard.putData("Power Distribution", powerDistribution);
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be
	 * created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
	 * an arbitrary
	 * predicate, or via the named factories in {@link
	 * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
	 * {@link
	 * CommandXboxController
	 * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
	 * PS4} controllers or
	 * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
	 * joysticks}.
	 */

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		return autoChooser.selectedCommandScheduler();
	}
}
