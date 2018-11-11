const Add = (function() {
	function Add() {}
	
	Add.prototype = {
		render: function() {
			//get info for forms
			fetch(`/api/artists`)
			.then(res => res.json())
			.then(data => {
				const select = document.querySelector('#artistSelect')
				data.forEach(artist => {
					select.innerHTML += `
						<option value="${artist.id}">${artist.name}</option>
					`
				})
				
				
			})
			fetch(`/api/albums`)
			.then(res => res.json())
			.then(data => {
				const select = document.querySelector('#albumSelect')
				data.forEach(album => {
					select.innerHTML += `
						<option value="${album.id}">${album.title}</option>
					`
				})
				
				
			})
			
			//addArtist
			setTimeout(()=>{
				document.querySelector('.addArtist button').addEventListener('click', () => {
					fetch(`/api/artists/add`, {
						method:'post',
						body: JSON.stringify({
							name: artistName.value,
							rating: artistRating.value,
							imageUrl: artistImageUrl.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
			}, 0)
			//addAlbum
			setTimeout(()=>{
				document.querySelector('.addAlbum button').addEventListener('click', () => {
					fetch(`/api/albums/add`, {
						method:'post',
						body: JSON.stringify({
							title: albumTitle.value,
							rating: albumRating.value,
							recordLabel: albumLabel.value,
							imageUrl: albumImageUrl.value,
							artist: artistSelect.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
			}, 0)
			
			//addSong
			setTimeout(()=>{
				document.querySelector('.addSong button').addEventListener('click', () => {
					fetch(`/api/songs/add`, {
						method:'post',
						body: JSON.stringify({
							title: songTitle.value,
							rating: songRating.value,
							duration: songDuration.value,
							album: albumSelect.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
			}, 0)
			
			//return page
			return `
				<main>
					<h2>Add To The Collection:</h2>
					<article class="addArtist">
						<h3>Add an artist:</h3>
						<label>Artist Name: <input id="artistName" type="text" name="name" /></label>
						<label>Rating: <input id="artistRating" type="number" name="rating" min="0" max="10"></label>
						<label>Image URL: <input id="artistImageUrl" type="text" name="imageUrl" /></label>
						<button>Add Artist</button>
					</article>
					<article class="addAlbum">
						<h3>Add an album:</h3>
						<label>Album Title: <input id="albumTitle" type="text" name="title" /></label>
						<label>Rating: <input id="albumRating" type="number" name="rating" min="0" max="10"></label>
						<label>Record Label: <input id="albumLabel" type="text" name="recordLabel"></label>
						<label>Image URL: <input id="albumImageUrl" type="text" name="imageUrl"></label>
						<label>Artist: 
							<select name="artist" id="artistSelect">
							</select>
						</label>
						<button>Add Album</button>
					</article>
					<article class="addSong">
						<h3>Add a song:</h3>
						<label>Song Title: <input id="songTitle" type="text" name="title" /></label>
						<label>Rating: <input id="songRating" type="number" name="rating" min="0" max="10"></label>
						<label>Duration: <input id="songDuration" type="text" name="duration"></label>
						<label>Album: 
							<select name="album" id="albumSelect">
							</select>
						</label>
						<button>Add Song</button>
					</article>
					
				</main>
			`
		}
	}

	return Add
})()

module.exports = {
	Add
}