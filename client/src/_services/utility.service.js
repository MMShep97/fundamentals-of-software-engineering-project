import {
    SENDGRID_API_KEY
} from '.././api-keys'

const sgMail = require('@sendgrid/mail');
sgMail.setApiKey(SENDGRID_API_KEY);

function sendEmail(to, name, from, subject, text) {
    const msg = {
            to: to,
            from: from,
            subject,
            subject,
            text: text
    };
    // },
    // function (error, response) {
    //     //uh oh, there was an error
    //     if (error) console.log(JSON.stringify(error));

    //     //everything's good, lets see what mandrill said
    //     else console.log(response);
    // });

    sgMail.send(msg);
}

export {
    sendEmail
}