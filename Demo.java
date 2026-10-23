import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
class Message{
    String name;
    String message;
    Message(String name1,String message1){
        name=name1;
        message=message1;
    }
}

class SenderDetector extends JFrame{
    public void showMessageDialog(Message messageObj){
        
    }
    public String getname(){
        return "";
    }
}
class NewSender extends SenderDetector{
    private String name;
    
    JTextField textField;
    JButton addButton;
    JButton sendButton;
    JPanel centerPanel;
    JLabel centerLabel;
    
    Message[] messageArray=new Message[0];
    NewSender(String name){
        setSize(300,300); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle(name);
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        JLabel label1=new JLabel(name,JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("",Font.BOLD,15));
        addButton=new JButton("+");
        panel1.add(label1);
        panel1.add(addButton);
       
        this.name=name;
        add("North",panel1);
       
        centerPanel=new JPanel();
        add("Center",centerPanel);
       
        JPanel panel2=new JPanel(new FlowLayout());
        textField = new JTextField(15);
        sendButton=new JButton("Send >");
       
        panel2.add(textField);
        panel2.add(sendButton);
       
        add("South",panel2);
       
        setVisible(true);
       
        sendButton.addActionListener(new ActionListener(){
            public  void actionPerformed(ActionEvent evt){
               String message=textField.getText();
               Message m1=new Message(name,message);
               addCenterLabel(m1);
               //centerLabel.setText("Me : "+message);
               sendothersMessages(m1);
               
                textField.setText("");  
            }
            
        });
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                goToControlRoom();
                
            }
        });
       
    }
    public static void goToControlRoom(){
        ControlRoom.addNewSenders();
    }
    public void addCenterLabel(Message messageObj){
        extendMessageArray();
        messageArray[messageArray.length-1]=messageObj;
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        
        String name1;
        for(int i=0;i<messageArray.length;i++){
            if(messageArray[i].name.equals(this.name)){
               name1="Me";
            }else{
                name1=messageArray[i].name;
            }
            JLabel label=new JLabel(name1+" : "+messageArray[i].message);
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
    
    public static void sendothersMessages(Message messageObj){
        ControlRoom.othersMessages(messageObj);
    }
    
    public void showMessageDialog(Message messageObj){
        addCenterLabel (messageObj);
    }
    public String getname(){
        return name;
    }
}

class AddSender extends JFrame{
    AddSender(){
        setSize(300,100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Add Sender");
        
        JLabel label1=new JLabel("Add Sender ",JLabel.CENTER);
        label1.setFont(new Font("",Font.BOLD,20));
        
        JPanel centerPanel=new JPanel(new FlowLayout());
        JLabel label2=new JLabel("Sender Name",JLabel.CENTER);
        JTextField textField=new JTextField(15);
        JButton button=new JButton("Enter");
        button.setFont(new Font("",1,10));
        
        centerPanel.add(label2);
        centerPanel.add(textField);
        centerPanel.add(button);
        add("Center",centerPanel);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String name1=textField.getText();
                ControlRoom.addSenders(new NewSender(name1));
                textField.setText("");
            }
        });
        
        setVisible(true);
    }
}
class Sender1 extends SenderDetector{
    private String name;
    
    JTextField textField;
    JButton addButton;
    JButton sendButton;
    JPanel centerPanel;
    JLabel centerLabel;
    
    Message[] messageArray=new Message[0];
    Sender1(){
        setSize(300,300); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);
        setTitle("Sender 01");
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        JLabel label1=new JLabel("Sender 01",JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("",Font.BOLD,15));
        addButton=new JButton("+");
        panel1.add(label1);
        panel1.add(addButton);
       
        this.name="Sender 01";
        add("North",panel1);
       
        centerPanel=new JPanel();
        add("Center",centerPanel);
       
        JPanel panel2=new JPanel(new FlowLayout());
        textField = new JTextField(15);
        sendButton=new JButton("Send >");
       
        panel2.add(textField);
        panel2.add(sendButton);
       
        add("South",panel2);
       
        setVisible(true);
       
        sendButton.addActionListener(new ActionListener(){
            public  void actionPerformed(ActionEvent evt){
               String message=textField.getText();
               Message m1=new Message("Sender 01",message);
               addCenterLabel(m1);
               //centerLabel.setText("Me : "+message);
               sendothersMessages(m1);
               
                textField.setText("");  
            }
            
        });
        
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                goToControlRoom();
            }
        });
       
    }
    
    public static void goToControlRoom(){
        ControlRoom.addNewSenders();
    }
    
    public void addCenterLabel(Message messageObj){
        extendMessageArray();
        messageArray[messageArray.length-1]=messageObj;
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        
        String name1;
        for(int i=0;i<messageArray.length;i++){
            if(messageArray[i].name.equals(this.name)){
               name1="Me";
            }else{
                name1=messageArray[i].name;
            }
            JLabel label=new JLabel(name1+" : "+messageArray[i].message);
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
    
    public static void sendothersMessages(Message messageObj){
        ControlRoom.othersMessages(messageObj);
    }
    
    public void showMessageDialog(Message messageObj){
        addCenterLabel(messageObj);
    }
    public String getname(){
        return name;
    }
}
class Sender2 extends SenderDetector{
    private String name;
    
    JTextField textField;
    JButton addButton;
    JButton sendButton;
    JPanel centerPanel;
    JLabel centerLabel;
    
    Message[] messageArray=new Message[0];
    Sender2(){
        setSize(300,300); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300,0);
        setTitle("Sender 02");
        JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        JLabel label1=new JLabel("Sender 02",JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("",Font.BOLD,15));
        addButton=new JButton("+");
        panel1.add(label1);
        panel1.add(addButton);
       
        this.name="Sender 02";
        add("North",panel1);
       
        centerPanel=new JPanel();
        add("Center",centerPanel);
       
        JPanel panel2=new JPanel(new FlowLayout());
        textField = new JTextField(15);
        sendButton=new JButton("Send >");
       
        panel2.add(textField);
        panel2.add(sendButton);
       
        add("South",panel2);
       
        setVisible(true);
       
        sendButton.addActionListener(new ActionListener(){
            public  void actionPerformed(ActionEvent evt){
               String message=textField.getText();
               Message m1=new Message("Sender 02",message);
               addCenterLabel(m1);
               //centerLabel.setText("Me : "+message);
               sendothersMessages(m1);
               
                textField.setText("");  
            }
            
        });
        
         addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                goToControlRoom();
            }
        });
       
    }
    public static void goToControlRoom(){
        ControlRoom.addNewSenders();
    }
    public void addCenterLabel(Message messageObj){
        extendMessageArray();
        messageArray[messageArray.length-1]=messageObj;
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        
        String name1;
        for(int i=0;i<messageArray.length;i++){
            if(messageArray[i].name.equals(this.name)){
               name1="Me";
            }else{
                name1=messageArray[i].name;
            }
            JLabel label=new JLabel(name1+" : "+messageArray[i].message);
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
    
    public static void sendothersMessages(Message messageObj){
        ControlRoom.othersMessages(messageObj);
    }
    
    public void showMessageDialog(Message messageObj){
        addCenterLabel( messageObj);
    }
    public String getname(){
        return name;
    }
}

class Sender3 extends SenderDetector{
    private String name;
    
    JTextField textField;
    JButton addButton;
    JButton sendButton;
    JPanel centerPanel;
    JLabel centerLabel;
    
    Message[] messageArray=new Message[0];
    Sender3(){
        setSize(300,300); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(600,0);
        setTitle("Sender 03");
       JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        JLabel label1=new JLabel("Sender 03",JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("",Font.BOLD,15));
        addButton=new JButton("+");
        panel1.add(label1);
        panel1.add(addButton);
       
        this.name="Sender 03";
        add("North",panel1);
       
        centerPanel=new JPanel();
        add("Center",centerPanel);
       
        JPanel panel2=new JPanel(new FlowLayout());
        textField = new JTextField(15);
        sendButton=new JButton("Send >");
       
        panel2.add(textField);
        panel2.add(sendButton);
       
        add("South",panel2);
       
        setVisible(true);
       
        sendButton.addActionListener(new ActionListener(){
            public  void actionPerformed(ActionEvent evt){
               String message=textField.getText();
               Message m1=new Message("Sender 03",message);
               addCenterLabel(m1);
               sendothersMessages(m1);
               
                textField.setText("");  
            }
            
        });
        
         addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               goToControlRoom();
            }
        });
       
    }
    public static void goToControlRoom(){
        ControlRoom.addNewSenders();
    }
    
    public void addCenterLabel(Message messageObj){
        extendMessageArray();
        messageArray[messageArray.length-1]=messageObj;
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        
        String name1;
        for(int i=0;i<messageArray.length;i++){
            if(messageArray[i].name.equals(this.name)){
               name1="Me";
            }else{
                name1=messageArray[i].name;
            }
            JLabel label=new JLabel(name1+" : "+messageArray[i].message);
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
    
    public static void sendothersMessages(Message messageObj){
        ControlRoom.othersMessages(messageObj);
    }
    
    public void showMessageDialog(Message messageObj){
        addCenterLabel( messageObj);
    }
    public String getname(){
        return name;
    }
}

class Sender4 extends SenderDetector{
    private String name;
    
    JTextField textField;
    JButton addButton;
    JButton sendButton;
    JPanel centerPanel;
    JLabel centerLabel;
    
    Message[] messageArray=new Message[0];
    Sender4(){
        setSize(300,300); 
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(900,0);
        setTitle("Sender 04");
       JPanel panel1=new JPanel(new FlowLayout());
        panel1.setBackground(Color.BLUE);
        JLabel label1=new JLabel("Sender 04",JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("",Font.BOLD,15));
        addButton=new JButton("+");
        panel1.add(label1);
        panel1.add(addButton);
       
        this.name="Sender 04";
        add("North",panel1);
       
        centerPanel=new JPanel();
        add("Center",centerPanel);
       
        JPanel panel2=new JPanel(new FlowLayout());
        textField = new JTextField(15);
        sendButton=new JButton("Send >");
       
        panel2.add(textField);
        panel2.add(sendButton);
       
        add("South",panel2);
       
        setVisible(true);
       
        sendButton.addActionListener(new ActionListener(){
            public  void actionPerformed(ActionEvent evt){
               String message=textField.getText();
               Message m1=new Message("Sender 04",message);
               addCenterLabel(m1);
               
               sendothersMessages(m1);
               
                textField.setText("");  
            }
            
        });
        
         addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                goToControlRoom();
            }
        });
       
    }
    public static void goToControlRoom(){
        ControlRoom.addNewSenders();
    }
    
    public void addCenterLabel(Message messageObj){
        extendMessageArray();
        messageArray[messageArray.length-1]=messageObj;
        centerPanel=new JPanel(new GridLayout(messageArray.length,1));
        
        String name1;
        for(int i=0;i<messageArray.length;i++){
            if(messageArray[i].name.equals(this.name)){
               name1="Me";
            }else{
                name1=messageArray[i].name;
            }
            JLabel label=new JLabel(name1+" : "+messageArray[i].message);
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
    
    public static void sendothersMessages(Message messageObj){
        ControlRoom.othersMessages(messageObj);
    }
    
    public void showMessageDialog(Message messageObj){
        addCenterLabel( messageObj);
    }
    public String getname(){
        return name;
    }
}


class ControlRoom extends JFrame{
    private static AddSender a1;
    private static SenderDetector[] senderDetectorArray=new SenderDetector[0];
    
    public static void addSenders(SenderDetector senderDetector){
        extendArray();
        senderDetectorArray[senderDetectorArray.length-1]=senderDetector;
        
    }
    public static void extendArray(){
        if(senderDetectorArray.length==0){
            SenderDetector[] temp = new SenderDetector[1];
            senderDetectorArray=temp;
        }else if(senderDetectorArray.length>0){
            SenderDetector[] temp = new SenderDetector[senderDetectorArray.length+1];
            
            for(int i=0;i<senderDetectorArray.length;i++){
                temp[i]=senderDetectorArray[i];
            }
            senderDetectorArray=temp;
        }
    }
    public static void othersMessages(Message messageObj){
        for(int i=0;i<senderDetectorArray.length;i++){
            if(senderDetectorArray[i].getname().equals(messageObj.name)){
                continue;
            }
            senderDetectorArray[i].showMessageDialog(messageObj);
        }
    }
    public static void addNewSenders(){
        if(a1==null){
            a1=new AddSender();
            
        }
    }
    
    
} 

class  Demo{
    public static void main(String args[]){
       ControlRoom c1=new ControlRoom();
       c1.addSenders(new Sender1());
       c1.addSenders(new Sender2());
       c1.addSenders(new Sender3());
       c1.addSenders(new Sender4());
    }
}
