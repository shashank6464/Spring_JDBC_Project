WEB LAYER CLIENT => displayed on the client

CONTROLLER => getPlayerController => Autowired Player DAO => view -> json data => client

DAO layer => PlayerDAO => @Autowired JDBCTemplate

=> Jdbc Template => Querying => From the Database, Mapping to => Player Model [Encapsulated Data]

DATABASE

Layers representation -> https://drive.google.com/file/d/1I3tRl8oKDn7YJBADJUisSqqQXmTJy-D0/view?usp=sharing

CLIENT => BROWSER => REQUEST => http://localhost:8080/movies  => GET


TOMCAT SERVER => 127.0.01:8080 => SpringBootJDBCApp => Class => @SpringBootApplication


SpringBootJDBCApp => @ComponentScan => Player Controller @RestController[Bean] => Default Constructor => @Autowired Player DAO


PlayerDAO.getAllPlayers() =>Communicate with the Database using JDBC Template=>  @Autowired JDBC Template => Querying, RowMapping [Player Model] DAO=>
