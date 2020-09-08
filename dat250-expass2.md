DAT250 - Experiment 2

1. Technical problems
- I had major problems with trying to get Windows' various CLIs to set environment variables for Derby. Ended up having to use a standalone Windows Terminal app.
- The importing of the Maven structure of the project took a bit of wrangling and googling to fix, but editing the pom.xml slighlty and re-importing finally solved my issues.
- I originally had "GenerationType.IDENTITY" for the id but that crashed the system.
- There was a LOT of intelliJ autofilling of get and set methods.


2. Link to code
- https://github.com/Zylvian/dat250-expass/tree/master/expass2/eclipselink/jpa-basic/src

3. Database inspection
- I used IntelliJ's "Java Enterprise" tab to inspect the database tables:
https://i.gyazo.com/15d62682c2802b57b727479c383ee90e.png

- I also used IntelliJ's "Persistence" tab to create a HR diagram:
https://i.gyazo.com/32e3875ecb95d857bafc5fea8b374bf7.png

4. Pending issues
- I couldn't get the objects to store properly, returning null values when printing them out. I was not able to get to the bottom of this, but will ask my fellow students at a later time.
