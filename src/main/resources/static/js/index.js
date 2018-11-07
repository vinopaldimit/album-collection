// Imported Components
const entry = document.querySelector('#app')
const { AppWrapper } = require('./appWrapper')
const { Main } = require('./main')

// App Components
const main = new Main()

//Imported Tools
const { makeElement } = require('./helpers')

// Build App
AppWrapper.innerHTML += main.render()

// Bootstrap Application
entry.appendChild(AppWrapper)