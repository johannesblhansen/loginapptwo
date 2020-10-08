--- DATA ---
The application builds on a hsqldb in file mode. 
To start that db, use following command: 
java -classpath hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/demodb --dbname.0 testdb

Remember to solve this after creating the datasource programmatically
https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-database-initialization

The application will currently needs to run with -filedb profile to use filebased db.

--- SECURITY ---
The security is configured using a WebSecurityConfiguration.
The the custom implementation of WebSecurityConfiguration overrides both the HttpSecurity object configure and 
AuthmanagerBuilder configure methods.
The AuthmanagerConfiguration configure is to add a custom provider to the auth manager.

The HttpSecurity configure is to an Antmatcher to the configuration.
This HttpSecurity makes a reroute to /login which triggers the predefined spring entity UsernamePasswordAuthenticationFilter.
This filter creates a UsernamePasswordAuthenticationToken which is a implementation of Authentication.

For the application I have made three WebSecurityConfiguration. All of them will create a filter chain with the root /**. 
To select one configuration over the others, edit the @Order annotation on the configuration class

- CustomAuthenticationConfiguration 
Custom filter and authentication object

- FormLoginWebSecurityConfiguration 
uses standard spring filter UsernamePasswordAuthenticationFilter. For implementation 
only a UserDetailsService is injected via the configuration. Authentication is handled in a default Spring provider 
using this service.