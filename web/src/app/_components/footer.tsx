import Container from "@/app/_components/container";
import { EXAMPLE_PATH } from "@/lib/constants";

export function Footer() {
  return (
    <footer className="">
      <Container>
        <div className="py-28 flex flex-col lg:flex-row items-center">
          <h3 className="text-4xl lg:text-[2.5rem] font-bold tracking-tighter leading-tight text-center lg:text-left mb-10 lg:mb-0 lg:pr-4 lg:w-1/2">
            Cheers
          </h3>
          <a
            href={`https://github.com/vzwork/tag`}
            className="mx-3 font-bold hover:underline"
          >
            View on GitHub
          </a>
        </div>
      </Container>
    </footer>
  );
}

export default Footer;
