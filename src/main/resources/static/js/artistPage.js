const ArtistPage = (function() {
	function ArtistPage(id) {
		this.id = id
	}
	
	ArtistPage.prototype = {
		render: function() {
			
			//artist
			fetch(`/api/artists/${this.id}`)
			.then(res => res.json())
			.then(data => {
				const section = document.querySelector('#currentDisplay')
				section.innerHTML = ``
				section.innerHTML += `
					<h3>${data.name}</h3>
					<figure>
						<img src="${data.imageUrl}" alt="Picture of the band.">
					</figure>
				`
					
				data.albums.forEach(album => {
					const button = document.createElement('button')
					button.id = `#album${album.id}`
					button.classList.add('albumButton')
					
					button.innerHTML = `${album.title}`
						
					button.addEventListener("click", () => {console.log(`hey ${album.id}`)})
					
					section.appendChild(button)
					
				})
			})
			
			return `
				<section id="currentDisplay"></section>
			`
		}
	}

	return ArtistPage
})()

module.exports = {
	ArtistPage
}