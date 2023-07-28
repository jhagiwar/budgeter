import React, { useState } from "react";

function LikeButton() {
    const [active, setActive] = useState(false);
    function activateOnClick() {
            setActive(true);
    }
    return (
    <div> can import other components</div>
  )
}

export default LikeButton