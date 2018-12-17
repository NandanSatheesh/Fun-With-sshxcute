package demo ;

import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;

public class test {

public static void main(String args[]) throws Exception{

    // Initialize a ConnBean object, parameter list is ip, username, password

    ConnBean cb = new ConnBean("<ip address>", "<username>","<password>");

    // Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a singleton SSHExec instance

    SSHExec ssh = SSHExec.getInstance(cb);   
       
    // Connect to server

    ssh.connect();

    CustomTask sampleTask1 = new ExecCommand("echo $SSH_CLIENT"); // Print Your Client IP By which you connected to ssh server

    System.out.println(ssh.exec(sampleTask1));

    
    
    CustomTask sampleTask2 = new ExecCommand("sqoop eval --connect jdbc:oracle:thin:@!@#:his --driver oracle.jdbc.driver.OracleDriver --username <!@#> --password <!@#> --query 'select * from <!!@#>'");

    ssh.exec(sampleTask2);

    ssh.disconnect();
    
    System.out.println("ssh -> exit");
}
}