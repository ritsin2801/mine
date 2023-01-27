import { Link } from "react-router-dom"

const Header = () => {
    return (
        <header className="Header">
            <nav>
                <ul>
                    <li className="back"><Link to="/">Back to index</Link></li>
                </ul>
                <div>
                    <Link to="post"><button className="ad">Add Post</button></Link>
                </div>

            </nav>
        </header>
    )
}

export default Header