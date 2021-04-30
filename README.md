# terminal

A basic TUI(terminal user interface ) for Java. It works on "sane" terminal mode and NOT raw mode. Has only being tested under Linux. 

     Terminal ter = new Terminal();`  

      ter.move(20, 20);
      ter.print("this should appear on 20:20");
      ter.renderBlock("my block", new Rectangle(30, 25, 100, 20));
      ter.move(32, 28);
      ter.print("inside the block");
      ter.flush();
this code will print this. 
