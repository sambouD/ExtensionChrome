
 const eventSource = new EventSource("http://localhost:8080/api/sse");

//const eventSource = new EventSource("http://192.168.142.29:8080/api/sse");



eventSource.onmessage = function (event) {
    const eventData = JSON.parse(event.data);
    const notificationMessage = eventData.message;
    console.log("Event received:", notificationMessage);

        // Assurez-vous que chrome.notifications est disponible
        if (chrome && chrome.notifications) {
      
            chrome.notifications.create({
                type: "basic",
                iconUrl: "img/notification.png",
                title: "Rappel",
                message:  notificationMessage
            });
        } 
}






//  setInterval(function () {

//  fetch('http://localhost:8080/api/get-last-message')
//     .then(response => response.json())
//     .then(data => {
//         console.log(data.checked);
//         if (chrome.notifications && data.checked === false) {
//             console.log("message ====", data);
//             chrome.notifications.create({
//                 type: 'basic',
//                 iconUrl: "img/notification.png",
//                 title: "Rappel",
//                 message: data,
//             });
//         }
//     })
//         .catch(error => console.error('Erreur lors de la récupération du dernier message:', error));
// }, 500); 



/*------------------------------------------------------------------*/



const eventReminderSource = new EventSource("http://192.168.142.29:8080/api/sseReminder");


eventReminderSource.onmessage = function (event) {
    const eventData = JSON.parse(event.data);
    const notificationMessage = eventData.message;
    console.log("Event received:", notificationMessage);


    // Assurez-vous que chrome.notifications est disponible
    if (chrome && chrome.notifications) {
      
        chrome.notifications.create({
            type: "basic",
            iconUrl: "img/notification.png",
            title: "Rappel",
            message:  notificationMessage
        });
    } 
}


