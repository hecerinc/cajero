# this is a random comment

PROJDIR = C:/xampp/tomcat/webapps/cajero/
WEBINF = $(PROJDIR)WEB-INF/classes
TOMCATLIB = C:/xampp/tomcat/lib
CLASSPATH = "$(TOMCATLIB)/servlet-api.jar;$(TOMCATLIB)/mysql-connector-5.1.38.jar;$(PROJDIR)"
# BINARIES = Cuenta.class ControlExtraccion.class InterfazConsulta.class InterfazExtraccion.class InterfazTransferencia.class
JAVAFILES = ControlExtraccion.java Cuenta.java InterfazConsulta.java InterfazExtraccion.java InterfazTransferencia.java

# search these paths for prereqs
VPATH = Controles;Entidades;Interfaces

all: $(JAVAFILES)
	javac -d "$(WEBINF)/" -cp $(CLASSPATH) $?

all2: $(BINARIES)
	@echo "Done!"

%.class: %.java
	javac -d "$(WEBINF)/" -cp $(CLASSPATH) $<

clean:
	rm -rf $(WEBINF)/*
