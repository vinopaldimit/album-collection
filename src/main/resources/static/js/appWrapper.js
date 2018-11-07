const { makeElement } = require('./helpers')

const AppWrapper = (function() {
	// App Wrapper
	const appWrapper = makeElement('div')
	appWrapper.classList.add('wrapper')
	
	return appWrapper
})()

module.exports = {
	AppWrapper
}