const Main = (function() {
	function Main() {}
	
	Main.prototype = {
		render: function() {
			return `
				<main>
					<h2>My Subheading</h2>
				</main>
			`
		}
	}

	return Main
})()

module.exports = {
	Main
}