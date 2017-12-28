package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FTC on 12/15/2017.
 */
@TeleOp(name="Object Tracking", group="Auto")
public class Test_Op extends LinearOpMode {
    public static final String TAG = "Vuforia VuMark Sample";
    public void runOpMode()
    {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        //VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey ="AQfJKg//////AAAAGfhdXDpBIkZsuqv7DLHnMuJkc7L/NiOpjZwcc7V37m5fKqmxUWj0yGyPoe6Q23I8yT0OMmAyRSG4PsfdPj9nrEiY0kOD+bLX5GJ12GTYG0huNvCaDymnVyqBLe8DD0SxUBrT8xXt8x51zB7Pf1YRA0az5KN+5sINsVuK3yivz6BxpMRHbTl4FXSn6UjJW7usMqRolDKmfbdE6OzWUFNo++bUuG1HwqoOMmitAVF+5GFn5SnjuYSw589BzktdoRj+rDCUlGhx3JOzqfzTbKTzKCMOu54uwtbRGrxwMgs4XthWxclfSC3b+GgXD5YYLZu8N092AqNkmgtVj6f5h5BkI6rlo0qnnPwQkT98AGp5lUE2" ;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables dude = vuforia.loadTrackablesFromAsset("Relic_Photo");
        dude.get(2).setName("creepy");
        dude.get(1).setName("music");
        dude.get(0).setName("cool dog");



        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();

        allTrackables.addAll(dude);



        telemetry.addData("<","push the button");
        telemetry.update();
        waitForStart();
        dude.activate();
        while(opModeIsActive())
        {

            
            telemetry.update();
            VuforiaTrackable target = dude.get(0);
            VuforiaTrackableDefaultListener listener = (VuforiaTrackableDefaultListener)target.getListener();
            if (listener.isVisible()!=false)
            {
                telemetry.addData("<","found something");
                telemetry.addData("<",target.getName());
            }
            else
            {
                telemetry.addData("<","found nothing");
            }
            VuforiaTrackable target2 = dude.get(1);
            VuforiaTrackableDefaultListener listener2 = (VuforiaTrackableDefaultListener)target2.getListener();
            if (listener2.isVisible()!=false)
            {
                telemetry.addData("<","found something");
                telemetry.addData("<",target2.getName());
            }
            else
            {
                telemetry.addData("<","found nothing");
            }
            VuforiaTrackable target3 = dude.get(2);
            VuforiaTrackableDefaultListener listener3 = (VuforiaTrackableDefaultListener)target3.getListener();
            if (listener3.isVisible()!=false)
            {
                telemetry.addData("<","found something");
                telemetry.addData("<",target3.getName());
            }
            else
            {
                telemetry.addData("<","found nothing");
            }
            VuforiaTrackable target4 = dude.get(3);
            VuforiaTrackableDefaultListener listener4 = (VuforiaTrackableDefaultListener)target4.getListener();
            if (listener4.isVisible()!=false)
            {
                telemetry.addData("<","found something");
                telemetry.addData("<",target4.getName());
            }
            else
            {
                telemetry.addData("<","found nothing");
            }
            VuforiaTrackable target5 = dude.get(4);
            VuforiaTrackableDefaultListener listener5 = (VuforiaTrackableDefaultListener)target5.getListener();
            if (listener5.isVisible()!=false)
            {
                telemetry.addData("<","found something");
                telemetry.addData("<",target5.getName());
            }
            else
            {
                telemetry.addData("<","found nothing");
            }
        } // end of opmode


    } // end of main function


} // end of program
