package org.firstinspires.ftc.teamcode;


import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.GlyphDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by FTC on 12/19/2017.
 */
@Autonomous(name="Sarah_Auto_Epic", group="Autonomous")


public class Sarah_Epic_Auto extends OpMode {
    //public static final String TAG = "Vuforia VuMark Sample";
    private ElapsedTime runtime = new ElapsedTime();
    private GlyphDetector glyphDetector = null;
    OpenGLMatrix lastLocation = null;
    DcMotor left_motor;
    DcMotor right_motor;
    //ClosableVuforiaLocalizer New_Var_Close = new ClosableVuforiaLocalizer();

    int var = 1;
    double Xpos=0;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
   ClosableVuforiaLocalizer vuforia;

    // Variables Store Here


    public void init() {
        // Init Goes Here

       int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        ClosableVuforiaLocalizer.Parameters parameters = new ClosableVuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AQfJKg//////AAAAGfhdXDpBIkZsuqv7DLHnMuJkc7L/NiOpjZwcc7V37m5fKqmxUWj0yGyPoe6Q23I8yT0OMmAyRSG4PsfdPj9nrEiY0kOD+bLX5GJ12GTYG0huNvCaDymnVyqBLe8DD0SxUBrT8xXt8x51zB7Pf1YRA0az5KN+5sINsVuK3yivz6BxpMRHbTl4FXSn6UjJW7usMqRolDKmfbdE6OzWUFNo++bUuG1HwqoOMmitAVF+5GFn5SnjuYSw589BzktdoRj+rDCUlGhx3JOzqfzTbKTzKCMOu54uwtbRGrxwMgs4XthWxclfSC3b+GgXD5YYLZu8N092AqNkmgtVj6f5h5BkI6rlo0qnnPwQkT98AGp5lUE2";
        parameters.cameraDirection = ClosableVuforiaLocalizer.CameraDirection.BACK;
        ClosableVuforiaLocalizer vuforia = new ClosableVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary
        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        Servo phone;
        Servo stick;
        phone = hardwareMap.get(Servo.class, "phone");
        stick = hardwareMap.get(Servo.class, "stick");
        left_motor = hardwareMap.get(DcMotor.class,"left");
        right_motor = hardwareMap.get(DcMotor.class,"right");
        glyphDetector = new GlyphDetector();
        glyphDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        glyphDetector.minScore = 1;
        glyphDetector.downScaleFactor = 0.3;
        glyphDetector.speed = GlyphDetector.GlyphDetectionSpeed.SLOW;
        //glyphDetector.enable();


        phone.setPosition(.4);
    }

    @Override
    public void init_loop() {
        telemetry.addData("Status", "Initialized. Gyro Calibration");




    }

    @Override
    public void start() {
        runtime.reset();


    }


    @Override
    public void loop() {

        if (var == 1) {

            Drive_Forward(.4, 2.0);
            Drive_Forward(-.3,2.0);
            var = 2;
            vuforia.close();
        }
        if(var == 2){
            glyphDetector.enable();
            Xpos = FindGlyph();

            if(FindGlyph()!=0)
            {
                var = 3;
            }
        }
        if(var == 3)
        {
            telemetry.addLine("found block x value");
            telemetry.addData(">",Xpos);
        }






    }


    @Override
    public void stop() {
        glyphDetector.disable();
    }

public double FindGlyph(){
    if (glyphDetector.getChosenGlyphPosition() != null) {
        return glyphDetector.getChosenGlyphOffset();

    }
    else{
        return 0;
    }
    }

public int RelicLook(RelicRecoveryVuMark relicTemplate)
{
    int data=5;
    RelicRecoveryVuMark vuMark = relicTemplate;
        telemetry.addData("VuMark","%s visible",vuMark);
        telemetry.update();

        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

            if (vuMark == RelicRecoveryVuMark.LEFT) {
                data =0;
            } else if (vuMark == RelicRecoveryVuMark.CENTER) {
                data = 1;
            } else if (vuMark == RelicRecoveryVuMark.LEFT) {
                data = 2;
            }
        }

        return data;
    }

    public void Drive_Forward(double power,double time)
    {


        ElapsedTime new_time = new ElapsedTime();
        while(new_time.seconds()<time) {
            left_motor.setPower(power);
            right_motor.setPower(power);
        }
        left_motor.setPower(0);
        right_motor.setPower(0);
    }





}
