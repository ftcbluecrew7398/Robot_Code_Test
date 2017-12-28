package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

class Drive_Code {
        DcMotor left_Motor;
        DcMotor right_Motor;

public void Drive_Forward(double power,double time)

        {
        ElapsedTime new_time = new ElapsedTime();
        while(new_time.seconds()<time) {
        left_Motor.setPower(power);
        right_Motor.setPower(power);
        }
        left_Motor.setPower(0);
        right_Motor.setPower(0);
        }

private void Turn_To(double power, double time)
{
        ElapsedTime new_time = new ElapsedTime();
        while(new_time.seconds()<time) {
                left_Motor.setPower(power);
                right_Motor.setPower(-power);
        }
        left_Motor.setPower(0);
        right_Motor.setPower(0);
}


}