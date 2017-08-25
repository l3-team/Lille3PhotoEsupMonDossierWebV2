Java class client for use with RefPhoto
---


Pre-requisites :
---
- have a RefPhoto instance installed (https://github.com/l3-team/RefPhoto) or (https://github.com/l3-team/RefPhotoJ2EE)
- have esup-mon-dossier-web v2 installed (https://www.esup-portail.org/wiki/display/PROJMONDOSSIERWEB/2+-+MonDossierWeb+v2)

Installation :
---
- just copy the file Lille3Photo.java in folder : src/org/esupportail/mondossierweb/web/photo
- then configure the file properties/monDossierWeb/monDossierWeb.xml, simple adjust the url tokenurl and imageurl :
```
...
        <!-- Bean Photo pour Lille3 (inspiré de Nancy2) -->
        <bean id="photo"
        class="org.esupportail.mondossierweb.web.photo.Lille3Photo"
        scope="session">
                <property name="tokenurl">
                        <value>https://refphotos.univ.fr/tokenEtu/add/</value>
                </property>
                <property name="imageurl">
                        <value>https://refphotos.univ.fr/image/</value>
                </property>
        </bean>
...
```

Have fun!
