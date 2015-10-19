package org.usfirst.frc.team1294.robot.utilities;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.tables.ITable;

public class VersionInformation implements NamedSendable {

	private Manifest manifest;
	
	public VersionInformation() {
		this.manifest = loadManifest();
	}
	
	public String getBranch() {
		return getAttribute("Git-Branch");
	}
	
	public String getHash() {
		return getAttribute("Git-Hash");
	}
	
	public String getTimestamp() {
		return getAttribute("Git-Timestamp");
	}
	
	public String getTag() {
		return getAttribute("Git-Tag");
	}
	
	public String getAuthor() {
		return getAttribute("Git-Author");
	}
	
	private Manifest loadManifest() {
		URLClassLoader cl = (URLClassLoader) VersionInformation.class
				.getClassLoader();
		try {
			URL url = cl.findResource("META-INF/MANIFEST.MF");
			return new Manifest(url.openStream());
		} catch (IOException ex) {
			return null;
		}
	}

	private String getAttribute(String attribute) {
		if (manifest == null) {
			return null;
		}
		Attributes attrs = manifest.getMainAttributes();
		String attr = attrs.getValue(attribute);
		return attr == null ? "<not found>" : attr;
	}
	
	private ITable table;
    

	@Override
	public String getSmartDashboardType() {
		return "SubSystem";
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public void initTable(ITable table) {
        this.table = table;
        if(table!=null) {
        	if (manifest != null) {
        		table.putBoolean("HasVersionInformation", true);
        		table.putString("Git-Branch", getBranch());
        		table.putString("Git-Hash", getHash());
        		table.putString("Git-Timestamp", getTimestamp());
        		table.putString("Git-Tag", getTag());
        		table.putString("Git-Author", getAuthor());
        	} else {
        		table.putBoolean("HasVersionInformation", false);
        	}
        }
    }

	@Override
	public String getName() {
		return "VersionInformation";
	}
}
