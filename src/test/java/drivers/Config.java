package drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config
{
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	public Config(String fileName) throws IOException
	{
		this.RepositoryFile = fileName;
		stream = new FileInputStream(RepositoryFile);
		propertyFile.load(stream);
	}

	public String getObject(String Object)
	{
		String ObjectValue = propertyFile.getProperty(Object);
		return ObjectValue;
	}

}
