package org.bloom.plugin;

import org.bloom.Bloom;
import org.bloom.event.PluginStartingEvent;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * A Bloom JavaPluginLoader
 */
public class JavaPluginLoader {
    public static Map<String, Plugin> nameToPlugin = new HashMap<String, Plugin>();

    public static void loadPluginFile(File file) throws Exception{
        JarFile jarFile = new JarFile(file);
        JarEntry propertiesEntry = jarFile.getJarEntry("plugin.properties");
        InputStream propertiesStream = jarFile.getInputStream(propertiesEntry);
        Properties properties = new Properties();
        properties.load(propertiesStream);
        String mainClassPath = properties.getProperty("main");
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{ url };
        URLClassLoader loader = new URLClassLoader(urls);
        Class mainClass = loader.loadClass(mainClassPath);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.setDaemon(true);
        Object instance = mainClass.getConstructor(Thread.class).newInstance(thread);
        if(!(instance instanceof Plugin)){
            throw new Exception();
        }
        Plugin plugin = (Plugin) instance;
        plugin.startPlugin();
        nameToPlugin.put(plugin.getName(), plugin);
        Bloom.getEventManager().callEvent(new PluginStartingEvent(plugin));
    }

    public static Plugin[] getPlugins(){
        ArrayList<Plugin> plugins = new ArrayList<Plugin>();
        for (Map.Entry<String, Plugin> pluginEntry : nameToPlugin.entrySet()){
            plugins.add(pluginEntry.getValue());
        }
        return plugins.toArray(new Plugin[plugins.size()]);
    }
}
