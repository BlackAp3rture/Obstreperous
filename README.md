#Obstreperous



    ________  ___.              __                                                                
    \_____  \ \_ |__    _______/  |_ _______   ____  ______    ____ _______   ____   __ __  ______
     /   |   \ | __ \  /  ___/\   __\\_  __ \_/ __ \ \____ \ _/ __ \\_  __ \ /  _ \ |  |  \/  ___/
    /    |    \| \_\ \ \___ \  |  |   |  | \/\  ___/ |  |_> >\  ___/ |  | \/(  <_> )|  |  /\___ \ 
    \_______  /|___  //____  > |__|   |__|    \___  >|   __/  \___  >|__|    \____/ |____//____  >
            \/     \/      \/                     \/ |__|         \/                           \/ 






Obstreperous is an introduction to application security development that provides examples of both insecure instrumentation and its secure counterpart. The examples are very simplistic and only provide a more secure direction for a developer and may not be adequet for a production application. 

##Android Examples:
* Data Storage

* Binary Protections

* Crypto

* Exported Intents

* Exported Services

* Transport Layers

* URL Schemes - Cooming Soon

* Attacking Intents and Services - Coming Soon

* Directory Traversals - Coming Soon

* Native Libraries - Coming Soon


##iOS Examples:

* Coming Soon

##Web Examples:

* Coming Soon


##Setup

With ruby installed, run:

     ➜  obstreperous git:(master) ✗  cd api/
     
     ➜  api git:(master) ✗ ./setup.sh

Then:

    ➜  api git:(master) ✗ ./start.sh <-- This will run on localhost:4567/home

    ➜  api git:(master) ✗ ./stop.sh <-- To stop the service.
    
    
##Information
 - The HTTP service is required for some modules of the application to work. 
 - Some network features may not work using an Android VM. This was designed with having a physical device in mind.
 

