// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.subsystems.Vision;
import frc.robot.util.Elastic.Notification;
import frc.robot.util.Elastic.Notification.NotificationLevel;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


    /** A set of constants related to the drivetrain. */
    public static class DriveConstants {

        public static final int frontLeftSwervePort = 1;
        public static final int frontRightSwervePort = 3;
        public static final int backLeftSwervePort = 5;
        public static final int backRightSwervePort = 7;

        public static final int[] swerveMotorPorts = {
            frontLeftSwervePort,
            frontRightSwervePort,
            backLeftSwervePort,
            backRightSwervePort
        };

        public static final int frontLeftDrivePort = 2;
        public static final int frontRightDrivePort = 4;
        public static final int backLeftDrivePort = 6;
        public static final int backRightDrivePort = 8;

        public static final int[] driveMotorPorts = {
            frontLeftDrivePort,
            frontRightDrivePort,
            backLeftDrivePort,
            backRightDrivePort
        };

        public static final boolean useEncoders = false;

        public static final int frontLeftEncoder = 0;
        public static final int frontRightEncoder = 1;
        public static final int backLeftEncoder = 3;
        public static final int backRightEncoder = 4;

        public static final int[] encoders = {
            frontLeftEncoder,
            frontRightEncoder,
            backLeftEncoder,
            backRightEncoder
        };

        public static final double[] absoluteOffsets = {
            /* MK4 module positions
            40.5,
            256.0,
            11.5,
            344.5
            */
            // MK4i module positions
            13.3,
            252.5,
            278.5,
            71.8
        };

        public static final double inchesFromRobotCenter = 11.75;
        public static final double metersFromRobotCenter = 
            Units.inchesToMeters(inchesFromRobotCenter);

        public static final Translation2d frontLeft = new Translation2d(
            metersFromRobotCenter, metersFromRobotCenter);
        public static final Translation2d frontRight = new Translation2d(
            metersFromRobotCenter, -metersFromRobotCenter);
        public static final Translation2d backLeft = new Translation2d(
            -metersFromRobotCenter, metersFromRobotCenter);
        public static final Translation2d backRight = new Translation2d(
            -metersFromRobotCenter, -metersFromRobotCenter);

        public static final double swerveP = 0.032;
        public static final double swerveI = 0.0;
        public static final double swerveD = 0.015;
        public static final double swerveFF = 0.0;

        public static final double xyP = 1.05;
        public static final double xyI = 0;
        public static final double xyD = 0;

        public static final double turnP = 8.192;
        public static final double turnI = 0.00000;
        public static final double turnD = 0.0016;
        public static final double turnR = 0.02;

        public static final double driveKs = 0.065;
        public static final double driveKv = 2.35;
        public static final double driveKa = 0.44;

        public static final SimpleMotorFeedforward[] driveFeedForward = {
            new SimpleMotorFeedforward(driveKs, driveKv, driveKa),
            new SimpleMotorFeedforward(driveKs, driveKv, driveKa),
            new SimpleMotorFeedforward(driveKs, driveKv, driveKa),
            new SimpleMotorFeedforward(driveKs, driveKv, driveKa)
        };


        public static final double highDriveSpeed = 5.18;
        public static final double speedModifier = 1;//0.65;

        public static final double inchesPerRotation = Math.PI * 3.875;
        public static final double metersPerRotation = Units.inchesToMeters(inchesPerRotation);

        public static final double swerveRotationToDegrees = 360.0 / (150.0 / 7.0);
        public static final double driveMotorToWheel = 1 / 6.12;

        public static final double nosBooster = 5.25;


        public static final Notification encoderError = new Notification(
            NotificationLevel.ERROR,
            "ABSOLUTE ENCODER NOT CONNECTED ON ONE OR MORE MODULES",
            "The absolute encoder for a swerve module is not connected! Please check the debugging tab to see which one."
        );

    }

	public static class OperatorConstants {
		public static final int driverControllerPort = 1;
		public static final int operatorControllerPort = 0;
	}


    /** A set of constants relating to vision. */
    public static class VisionConstants {
        public static final String ipAddress = "ws://10.54.80.123";
        public static final int[] CameraRotations = {0, 0, 0};
        public static final String[] tagIDs = {"1", "2", "12", "13", "6", "7", "8", "9", "10", "11", "17", "18", "19", "20", "21", "22"};
        public static HashMap<String, Integer> apriltagAngles = new HashMap<>();
        public static final double maxIntakeAngle = Math.PI/6;
        public static final double misallignedPieceOffset = Math.PI/12; // This is the angle to go at when the piece is misaligned and 1m away. It will be adjusted automatically for different angles.
        public static final int pieceDetectionCamIndex = 0; // Default camera index for piece detection

        // Positive x is away from reef, positive y is to left of reef
        public static Vision.RobotPositionOffset straightOffset = new Vision.RobotPositionOffset(0.25, 0, 0);
        public static Vision.RobotPositionOffset leftOffset = new Vision.RobotPositionOffset(0.25, 0.08, 0);
        public static Vision.RobotPositionOffset rightOffset = new Vision.RobotPositionOffset(0.25, -0.2, 0);

        public static double CoralYOffset = 0;
        public static double CoralXOffset = 0;
        public static double CoralAngleOffset = 0;
        public static int CoralCamIndex = 0;

        public static final double turnP = 20;
        public static final double turnI = 0.02;
        public static final double turnD = 0.02;

        public static final double moveP = 10.05;
        public static final double moveI = 0.0;
        public static final double moveD = 0.0;

        public static Vision.CameraPair cameraPair = new Vision.CameraPair(0, Math.PI/6+0.165,0.22, 0.005, 1, -Math.PI/6 - 0.08015, 0.3541, 0.11627);
        /** Constructs apriltags angles hashmap. */
        public VisionConstants() {
            apriltagAngles.put("13", 0);
            apriltagAngles.put("tag2", 45);
            apriltagAngles.put("tag3", 60);
            apriltagAngles.put("tag4", 90);
        }
    }

}