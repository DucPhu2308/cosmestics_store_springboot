/**
 * 
 */
btnCollapse = document.getElementById("btnCollapse")
sidebar = document.getElementById("sidebar")

btnCollapse.onclick = () => {
	
	 if (sidebar.classList.contains("close")) {
		 sidebar.classList.remove("close");
		 sidebar.classList.add("open");
	 } else {
		 console.log(sidebar)
		 sidebar.classList.remove("open");
		 sidebar.classList.add("close");
	 }
}