import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Message{
    String message;
    String id;
    
    Message(String message,String id){
        this.message=message;
        this.id=id;
    }
}
class DeviceDetector extends JFrame{
    public  void showMessageDialog(Message newMessage){
        
    }
    
}
class NewSender extends DeviceDetector{
    JButton addButton;
    JTextField textField;
    JButton sendButton;
    private  JPanel centerPanel;
    private String iD;
    private Message[] messageArray=new Message[0];
    NewSender(String name){
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle(name);
        this.iD=name;
        
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setForeground(Color.WHITE);
        JLabel label1=new JLabel(name);
        label1.setFont(new Font("",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        addButton=new JButton("+");
        addButton.setFont(new Font("",Font.BOLD,15));
        
        panel1.add(label1);
        panel1.add(addButton);
        add("North",panel1);
        
        JPanel panel3=new JPanel(new FlowLayout());
        textField=new JTextField(15);
        textField.setFont(new Font("",1,10));
        sendButton=new JButton("Send >");
        
        centerPanel=new JPanel();
        add("Center",centerPanel);
        panel3.add(textField);
        panel3.add(sendButton);
        
        add("South",panel3);
        
        setVisible(true);
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=textField.getText();
                Message newMessage=new Message(message,iD);
                sendMessageToCR(newMessage);
                
                textField.setText("");
            }
        });
        
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addNewSenders();
            }
        });
    }
    public  void addNewSenders(){
        ControlRoom.addNewSender();
    }
    public static void sendMessageToCR(Message newMessage){
        ControlRoom.sendothersMessages(newMessage);
    }
    public void showMessageDialog(Message newMessage){
        extendMessageArray();  
        messageArray[messageArray.length-1]=newMessage;
        
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        for(int i=0;i<messageArray.length;i++){
            String name="";
            if(messageArray[i].id.equals(iD)){
                name="Me";
            }else{
                name=messageArray[i].id;
            }
            JLabel label=new JLabel(name+" : "+messageArray[i].message);
            centerPanel.add(label);
            
        }
        
        add("Center",centerPanel);
        setVisible(true);
        
    }
    
    
    public void extendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[1];
            messageArray=temp;
        }else if(messageArray.length>0){
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
        
    }
}
class AddNewSender extends JFrame{
    JTextField textField;
    JButton enterButton;
    AddNewSender(){
        setSize(300,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add New Sender");
        JPanel panel=new JPanel(new FlowLayout());
        JLabel label1=new JLabel("Add Sender");
        textField=new JTextField(15);
        enterButton=new JButton("Enter");
        
        enterButton.setFont(new Font("",Font.BOLD,10));
        textField.setFont(new Font("",1,10));
        
        panel.add(label1);
        panel.add(textField);
        panel.add(enterButton);
        add("Center",panel);
        
        enterButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String name=textField.getText();
                sendToCR(name);
                
                dispose();
                setBackToNull();
            }
        });
        
        setVisible(true);
        
        
    }
    public void setBackToNull(){
        ControlRoom.seta1BackToNull();
    }
    public void sendToCR(String name){
        ControlRoom.addDevices(new NewSender(name));
    }
}
class Sender1 extends DeviceDetector{
    JButton addButton;
    JTextField textField;
    JButton sendButton;
    private  JPanel centerPanel;
    private String iD;
    private Message[] messageArray=new Message[0];
    Sender1(){
        setSize(300,300);
        setLocation(0,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sender 01");
        setResizable(false);
        this.iD="Sender 01";
        
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setForeground(Color.WHITE);
        JLabel label1=new JLabel("Sender 01");
        label1.setFont(new Font("",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        addButton=new JButton("+");
        addButton.setFont(new Font("",Font.BOLD,15));
        
        panel1.add(label1);
        panel1.add(addButton);
        add("North",panel1);
        
        JPanel panel3=new JPanel(new FlowLayout());
        textField=new JTextField(15);
        textField.setFont(new Font("",1,10));
        sendButton=new JButton("Send >");
        
        centerPanel=new JPanel();
        add("Center",centerPanel);
        panel3.add(textField);
        panel3.add(sendButton);
        
        add("South",panel3);
        
        setVisible(true);
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=textField.getText();
                Message newMessage=new Message(message,iD);
                sendMessageToCR(newMessage);
                
                textField.setText("");
            }
        });
        
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addNewSenders();
            }
        });
    }
    public  void addNewSenders(){
        ControlRoom.addNewSender();
    }
    public static void sendMessageToCR(Message newMessage){
        ControlRoom.sendothersMessages(newMessage);
    }
    public void showMessageDialog(Message newMessage){
        extendMessageArray();  
        messageArray[messageArray.length-1]=newMessage;
        
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        for(int i=0;i<messageArray.length;i++){
            String name="";
            if(messageArray[i].id.equals(iD)){
                name="Me";
            }else{
                name=messageArray[i].id;
            }
            JLabel label=new JLabel(name+" : "+messageArray[i].message);
            centerPanel.add(label);
            
        }
        
        add("Center",centerPanel);
        setVisible(true);
        
    }
    
    
    public void extendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[1];
            messageArray=temp;
        }else if(messageArray.length>0){
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
        
    }
}

class Sender2 extends DeviceDetector{
    JButton addButton;
    JTextField textField;
    JButton sendButton;
    private  JPanel centerPanel;
    private String iD;
    private Message[] messageArray=new Message[0];
    Sender2(){
        setSize(300,300);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sender 02");
        this.iD="Sender 02";
        
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setForeground(Color.WHITE);
        JLabel label1=new JLabel("Sender 02");
        label1.setFont(new Font("",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        addButton=new JButton("+");
        addButton.setFont(new Font("",Font.BOLD,15));
        
        panel1.add(label1);
        panel1.add(addButton);
        add("North",panel1);
        
        centerPanel=new JPanel();
        add("Center",centerPanel);
        
        JPanel panel3=new JPanel(new FlowLayout());
        textField=new JTextField(15);
        textField.setFont(new Font("",1,10));
        sendButton=new JButton("Send >");
        
        panel3.add(textField);
        panel3.add(sendButton);
        
        add("South",panel3);
        
        setVisible(true);
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=textField.getText();
                Message newMessage=new Message(message,iD);
                sendMessageToCR(newMessage);
                
                
                textField.setText("");
            }
        });
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addNewSenders();
            }
        });
        
    }
    public  void addNewSenders(){
        ControlRoom.addNewSender();
    }
    public static void sendMessageToCR(Message newMessage){
        ControlRoom.sendothersMessages(newMessage);
    }
    public void showMessageDialog(Message newMessage){
        extendMessageArray();
        messageArray[messageArray.length-1]=newMessage;
        
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        for(int i=0;i<messageArray.length;i++){
            String name="";
            if(messageArray[i].id.equals(iD)){
                name="Me";
            }else{
                name=messageArray[i].id;
            }
            JLabel label=new JLabel(name+" : "+messageArray[i].message);
            centerPanel.add(label);
            
        }
       
        add("Center",centerPanel);
         setVisible(true);
        
    }
    
    
    public void extendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[1];
            messageArray=temp;
        }else if(messageArray.length>0){
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
        
    }
}

class Sender3 extends DeviceDetector{
    JButton addButton;
    JTextField textField;
    JButton sendButton;
    private  JPanel centerPanel;
    private String iD;
    private Message[] messageArray=new Message[0];
    Sender3(){
        setSize(300,300);
        setLocation(600,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sender 03");
        this.iD="Sender 03";
        
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setForeground(Color.WHITE);
        JLabel label1=new JLabel("Sender 03");
        label1.setFont(new Font("",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        addButton=new JButton("+");
        addButton.setFont(new Font("",Font.BOLD,15));
        
        panel1.add(label1);
        panel1.add(addButton);
        add("North",panel1);
        
        JPanel panel3=new JPanel(new FlowLayout());
        textField=new JTextField(15);
        textField.setFont(new Font("",1,10));
        sendButton=new JButton("Send >");
        
        centerPanel=new JPanel();
        add("Center",centerPanel);
        panel3.add(textField);
        panel3.add(sendButton);
        
        add("South",panel3);
        
        setVisible(true);
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=textField.getText();
                Message newMessage=new Message(message,iD);
                sendMessageToCR(newMessage);
                
                
                textField.setText("");
            }
        });
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addNewSenders();
            }
        });
        
    }
    public  void addNewSenders(){
        ControlRoom.addNewSender();
    }
    
    public static void sendMessageToCR(Message newMessage){
        ControlRoom.sendothersMessages(newMessage);
    }
    public void showMessageDialog(Message newMessage){
        extendMessageArray();  
        messageArray[messageArray.length-1]=newMessage;
        
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        for(int i=0;i<messageArray.length;i++){
            String name="";
            if(messageArray[i].id.equals(iD)){
                name="Me";
            }else{
                name=messageArray[i].id;
            }
            JLabel label=new JLabel(name+" : "+messageArray[i].message);
            centerPanel.add(label);
            
        }
        
        add("Center",centerPanel);
        setVisible(true);
        
    }
    
    
    public void extendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[1];
            messageArray=temp;
        }else if(messageArray.length>0){
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
        
    }
}

class Sender4 extends DeviceDetector{
    JButton addButton;
    JTextField textField;
    JButton sendButton;
    private  JPanel centerPanel;
    private String iD;
    private Message[] messageArray=new Message[0];
    Sender4(){
        setSize(300,300);
        setLocation(900,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sender 04");
        this.iD="Sender 04";
        
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setForeground(Color.WHITE);
        JLabel label1=new JLabel("Sender 04");
        label1.setFont(new Font("",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        addButton=new JButton("+");
        addButton.setFont(new Font("",Font.BOLD,15));
        
        panel1.add(label1);
        panel1.add(addButton);
        add("North",panel1);
        
        JPanel panel3=new JPanel(new FlowLayout());
        textField=new JTextField(15);
        textField.setFont(new Font("",1,10));
        sendButton=new JButton("Send >");
        
        centerPanel=new JPanel();
        add("Center",centerPanel);
        panel3.add(textField);
        panel3.add(sendButton);
        
        add("South",panel3);
        
        setVisible(true);
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String message=textField.getText();
                Message newMessage=new Message(message,iD);
                sendMessageToCR(newMessage);
                
                textField.setText("");
            }
        });
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addNewSenders();
            }
        });
        
    }
    
    public  void addNewSenders(){
        ControlRoom.addNewSender();
    }
    
    public static void sendMessageToCR(Message newMessage){
        ControlRoom.sendothersMessages(newMessage);
    }
    public void showMessageDialog(Message newMessage){
        extendMessageArray();  
        messageArray[messageArray.length-1]=newMessage;
        
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        for(int i=0;i<messageArray.length;i++){
            String name="";
            if(messageArray[i].id.equals(iD)){
                name="Me";
            }else{
                name=messageArray[i].id;
            }
            JLabel label=new JLabel(name+" : "+messageArray[i].message);
            centerPanel.add(label);
            
        }
        
        add("Center",centerPanel);
        setVisible(true);
        
    }
    
    
    public void extendMessageArray(){
        if(messageArray.length==0){
            Message[] temp=new Message[1];
            messageArray=temp;
        }else if(messageArray.length>0){
            Message[] temp=new Message[messageArray.length+1];
            for(int i=0;i<messageArray.length;i++){
                temp[i]=messageArray[i];
            }
            messageArray=temp;
        }
        
    }
}


class ControlRoom{
    static AddNewSender a1;
    private static DeviceDetector[] devicesArray=new DeviceDetector[0];
    
    public static void addDevices(DeviceDetector device){
        extendArray();
        devicesArray[devicesArray.length-1]=device;
    }
    public static void extendArray(){
        if(devicesArray.length==0){
            DeviceDetector[] temp=new DeviceDetector[1];
            
            devicesArray=temp;
        }else if(devicesArray.length>0){
            DeviceDetector[] temp=new DeviceDetector[devicesArray.length+1];
            
            for(int i=0;i<devicesArray.length;i++){
                temp[i]=devicesArray[i];
            }
            devicesArray=temp;
        }
    }
    
    public static void sendothersMessages(Message newMessage){
        for(DeviceDetector device : devicesArray){
            device.showMessageDialog(newMessage);
        }
    }
    public static void addNewSender(){
        if(a1==null){
            a1=new AddNewSender();
        }
    }
    public static void seta1BackToNull(){
        a1=null;
    }
    
    
}
class Demo{
    public static void main(String args[]){
        ControlRoom c1=new ControlRoom();
        c1.addDevices(new Sender1());
        c1.addDevices(new Sender2());
        c1.addDevices(new Sender3());
        c1.addDevices(new Sender4());
    }
}
