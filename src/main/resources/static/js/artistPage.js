const ArtistPage = (function() {
	function ArtistPage(id) {
		this.id = id
	}
	
	ArtistPage.prototype = {
		render: function() {
			
			//ARTIST
			fetch(`/api/artists/${this.id}`)
			.then(res => res.json())
			.then(data => {
				
				const section = document.querySelector('#currentDisplay')
				
				section.innerHTML = ``
				section.innerHTML += `
					<h2>${data.name}</h2>
					<article>
						<figure>
							<img src="${data.imageUrl}" alt="Picture of the band.">
						</figure>
						<p>Rating: ${data.rating}/10</p>
						<p id="changeRating">
							<label>New Rating: <input id="newRating" type="text" name="rating" /></label>
							<button id="ratingSubmit">Change Rating</button>
						</p>
						<h3>Albums:</h3>
						<p id="albumList"></p>
					</article>
					<article>
						<h3>Tags:</h3>
						<p id="tagList"></p>
						<label>Tag: <input id="newTag" type="text" name="tag" /></label>
						<button id="tagSubmit">Add Tag</button>
					</article>
					<article id="commentSection">
						<h3>Comments:</h3>
						<label>Username: <input id="commentUserName" type="text" name="userName" /></label>
						<label>Comment: <input id="comment" type="text" name="comment" /></label>
						<button id="commentSubmit">Add Comment</button>
						<ul></ul>
					</article>
				`
				//albumList
				data.albums.forEach(album => {
					const button = document.createElement('button')
					button.id = `#album${album.id}`
					button.classList.add('albumButton')
					
					button.innerHTML = `${album.title}`
						
					button.addEventListener("click", () => {console.log(`hey ${album.id}`)})
					
					section.querySelector('article #albumList').appendChild(button)
					
				})
				
				//change rating
				section.querySelector('#ratingSubmit').addEventListener("click", () => {
					fetch(`/api/artists/${data.id}/rating/change`, {
						method:'post',
						body: JSON.stringify({
							rating: newRating.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
				
				//add tag
				section.querySelector('#tagSubmit').addEventListener("click", () => {
					fetch(`/api/artists/${data.id}/tags/add`, {
						method:'post',
						body: JSON.stringify({
							tagName: newTag.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
				
				
				//tagList
				data.tags.forEach(tag => {
					const button = document.createElement('button')
					button.innerHTML = `${tag.tagName}`
					section.querySelector('article #tagList').appendChild(button)
				})
				
				//add comment
				section.querySelector('#commentSubmit').addEventListener("click", () => {
					fetch(`/api/artists/${data.id}/comments/add`, {
						method:'post',
						body: JSON.stringify({
							userName: commentUserName.value,
							comment: comment.value,
						}),
					})
						.then(res => res.json())
						.then(data => console.log)
				})
				
				//display comments
				data.comments.forEach(comment => {
					const nextComment = document.createElement('li')
					nextComment.innerHTML = `<h4>${comment.userName}</h4><p>${comment.comment}</p>`
					section.querySelector('#commentSection ul').appendChild(nextComment);
				})
			})
			//artist fetch end
			//add tag fetch
//			const addTagButton = document.querySelector('button')
//
//			addTagButton.addEventListener('click', () => {
//				fetch(`/api/doggos/${window.location.pathname.split('/')[2]}/tags/add`, {
//					method:'post',
//					body: JSON.stringify({
//						tagName: input.value,
//					}),
//				})
//					.then(res => res.json())
//					.then(data => console.log)
//			})
			//ARTIST END
			
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