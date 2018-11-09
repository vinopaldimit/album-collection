// Imported Components
const entry = document.querySelector('#app')
const { AppWrapper } = require('./appWrapper')
const { Add } = require('./add')
const { ArtistPage } = require('./artistPage')
const { Nav } = require('./nav')

// App Components
const add = new Add()
const artistPage = new ArtistPage(1)
const nav = new Nav();

//Imported Tools
const { makeElement } = require('./helpers')

// Build App
AppWrapper.innerHTML += nav.render()
AppWrapper.innerHTML += artistPage.render()
AppWrapper.innerHTML += add.render()

// Bootstrap Application
entry.appendChild(AppWrapper)