<!DOCTYPE html>
<html>

<head>


</head>
<body>

	<form action="EpisodeController" method="GET">
		<input type="hidden" name="cmd" value="ADD"> <label
			for="fname">Which Episode ?</label><br> <input type="text"
			name="epno"><br> <label for="lname">Which Season
			?</label><br> <input type="text" name="season"><br> <label
			for="lname">Can you name the Episode?</label><br> <input
			type="text" name="epname"><br> <label for="lname">Rate
			it </label><br> <input type="text" name="rating"><br> <input
			type="submit" value="save"><br>
	</form>

	<a href="EpisodeController">Back</a>
</body>
</html>