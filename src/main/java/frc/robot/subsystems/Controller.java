package frc.robot.subsystems;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Controller extends SubsystemBase{
    public Swerve swerve;

    public CommandXboxController CmdXboxController = new CommandXboxController(0);
    public XboxController xboxController = new XboxController(0);

    public Controller (Swerve swerveSubsystem) {
        this.swerve = swerveSubsystem;
        CmdXboxController.leftBumper().onTrue(swerve.downshiftCommand);
        CmdXboxController.rightBumper().onTrue(swerve.upshiftCommand);
    }

    public void periodic(){
        swerve.setSpeeds(xboxController.getLeftX(), xboxController.getLeftY(), xboxController.getRightX(), false);
    }
    
}
