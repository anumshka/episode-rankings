<!DOCTYPE html>
<html>

<head>


</head>
<body>

	<form action="EpisodeController" method="GET">
		<input type="hidden" name="cmd" value="UPDATE"> <input
			type="hidden" name="epidInt" value="${THE_EPISODE.epid }"> <label
			for="fname">Which Episode ?</label><br> <input type="text"
			name="epno" value="${THE_EPISODE.epnum }"><br> <label
			for="lname">Which Season ?</label><br> <input type="text"
			name="season" value="${THE_EPISODE.season }"><br> <label
			for="lname">Can you name the Episode?</label><br> <input
			type="text" name="epname" value="${THE_EPISODE.epname }"><br>
		<label for="lname">Rate it </label><br> <input type="text"
			name="rating" value="${THE_EPISODE.rating}"><br> <input
			type="submit" value="save"><br>
	</form>

	<a href="EpisodeController">Back</a>
</body>
</html>