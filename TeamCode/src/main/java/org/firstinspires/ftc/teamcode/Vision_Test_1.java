package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by FTC on 12/27/2017.
 */

@Autonomous(name="Vision_Test", group="Auto")
public class Vision_Test_1 extends LinearOpMode {


public void runOpMode() {
    int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
    VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
    parameters.vuforiaLicenseKey = "AQfJKg//////AAAAGfhdXDpBIkZsuqv7DLHnMuJkc7L/NiOpjZwcc7V37m5fKqmxUWj0yGyPoe6Q23I8yT0OMmAyRSG4PsfdPj9nrEiY0kOD+bLX5GJ12GTYG0huNvCaDymnVyqBLe8DD0SxUBrT8xXt8x51zB7Pf1YRA0az5KN+5sINsVuK3yivz6BxpMRHbTl4FXSn6UjJW7usMqRolDKmfbdE6OzWUFNo++bUuG1HwqoOMmitAVF+5GFn5SnjuYSw589BzktdoRj+rDCUlGhx3JOzqfzTbKTzKCMOu54uwtbRGrxwMgs4XthWxclfSC3b+GgXD5YYLZu8N092AqNkmgtVj6f5h5BkI6rlo0qnnPwQkT98AGp5lUE2";
    parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
    ClosableVuforiaLocalizer vuforia = new ClosableVuforiaLocalizer(parameters);
    VuforiaTrackables Test_Track = vuforia.loadTrackablesFromAsset("RelicVuMark");
    VuforiaTrackable Test_Template = Test_Track.get(0);
    waitForStart();
    ElapsedTime newtime = new ElapsedTime();
    while (opModeIsActive()) {
        telemetry.update();

        while (newtime.seconds() < 5) {

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(Test_Template);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                /* Found an instance of the template. In the actual game, you will probably
                 * loop until this condition occurs, then move on to act accordingly depending
                 * on which VuMark was visible. */
                telemetry.addData("VuMark", "%s visible", vuMark);

            }
            telemetry.addData("VuMark", "%s visible", vuMark);

        }
        vuforia.close();
        idle();[]

    }
}









}