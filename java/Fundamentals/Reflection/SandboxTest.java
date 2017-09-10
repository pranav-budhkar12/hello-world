import java.util.*;
import java.lang.reflect.*;

class SandboxTest{

	static class CmdClassLoader extends ClassLoader{
		
		@Override
		public Class<?> findClass(String name) 
		throws ClassNotFoundException{
			String file = name.replace('.', '_') + ".cmd";
			byte[] binaries = DataFile.getBytes(file);
			if(binaries == null)
				throw new ClassNotFoundException(name);
			return defineClass(name, binaries, 0, binaries.length);
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		System.setProperty("java.security.policy", "sandbox.policy");
		System.setSecurityManager(new SecurityManager());
		for(;;){
			System.out.print("SBT::");
			String cmd = input.next();
			if(cmd.equals("quit")) break;
			try{
				Class<?> c = Class.forName("commands." + cmd,
					true, new CmdClassLoader());
				Method m = c.getMethod("execute", String.class);
				m.invoke(null, "SandboxTest");
			}catch(Exception e){
				System.out.printf("ERROR: %s%n", e);
			}
			System.out.println();
		}
	}
}






















