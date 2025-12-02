#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


void solve() {

	char c;
	std::cin >> c;
	std::string str;
	switch (c) {
		case 'F':
			str = "Foundation";
			break;
		case 'C':
			str = "Claves";
			break;
		case 'V':
			str = "Veritas";
			break;
		case 'E':
			str = "Exploration";
			break;
	}
	std::cout << str;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}