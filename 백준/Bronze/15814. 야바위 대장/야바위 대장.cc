#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string line;
	std::getline(std::cin, line);

	int n;
	std::cin >> n;

	
	while (n--) {
		int a, b;
		std::cin >> a >> b;
		char c = line[a];
		line[a] = line[b];
		line[b] = c;
		
	}

	std::cout << line;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}