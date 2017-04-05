// comentario
class Buffer {
   private char [] buffer;
   private int count = 0, in = 0, out = 0;

   Buffer(int size)
   {
      buffer = new char[size];
   }
 
   public synchronized void put(char c) {
     while(count == buffer.length) ;
     System.out.println("Produciendo " + c + " ...");
     buffer[in] = c; 
     in = (in + 1) % buffer.length; 
     count++;
   }
    
   public synchronized char get() {
     while (count == 0) ;
     char c = buffer[out]; 
     out = (out + 1) % buffer.length;
     count--;
     System.out.println("Consumiendo "+ c + " ...");
     return c;
   }
}
     
